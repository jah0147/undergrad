package sample;

import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Bounds;
import javafx.geometry.Rectangle2D;
import javafx.scene.shape.Rectangle;
import javafx.scene.Group;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.*;
import javafx.scene.Scene;
import javafx.fxml.FXML;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.SnapshotParameters;
import javafx.scene.image.WritableImage;

public class Main extends Application {

    //Variables
    private Popup popup;
    private AnchorPane grid;
    private Scene scene;
    @FXML
    private ImageView imageViewMain; // Value injected by FXMLLoader
    private RubberBandSelection rubberBandSelection;
    private boolean isCleared;
    @FXML
    private VBox scrollVBox;
    @FXML
    private ScrollPane scrollPane;
    private Text pleaseBrowseText;
    private ToggleButton toggleButton;
    private Stage primaryStage;
    private File excelFile;
    private Bounds selectionBounds;
    private int numOfImages;
    private LabelData previousData[];
    private ImageView imageViews[];
    private CsvReadWrite csvReadWrite = new CsvReadWrite();
    private ImageView imagesSource;
    private String imageName;
    private String csv;
    private boolean hasBeenRead = false;
    private File filesImage[];
    private Image images[];
    private BufferedImage bufferedImage[];
    private int imageNumber;

    //The GUI interface scene
    @Override
    public void start(Stage primaryStage) throws Exception {

        this.primaryStage = primaryStage; //sets this primaryStage as 'the' primaryStage
        grid = FXMLLoader.load(getClass().getResource("GUI.fxml")); //Calls the TitledPane from the fxml file

        /**
         * MAIN STAGE CREATED
         * Main Stage and Scene Created and shown
         */
        scene = new Scene(grid); //creates a new scene from the TitlesPane created in 'GUI.fxml'
        primaryStage.setTitle("Photo Cropping Tool"); //sets the title of the app
        primaryStage.setScene(scene); //sets the scene on the stage
        primaryStage.show(); //shows the primaryStage
        primaryStage.setAlwaysOnTop(false); //set to false to show popups
        primaryStage.setResizable(true); //makes app unable to be resized

        /**
         * IMAGE LAYER GROUP
         * New group for the image layer
         * (used so you can snapshot the current photo and crop
         */
        Group imageLayer = (Group) scene.lookup("#imageLayer"); //calls the group created from the fxml file
        imageViewMain = new ImageView(); //creates new imageView container for the group
        imageLayer.getChildren().addAll(imageViewMain); //puts the imageView in the group so it can be edited

        /**
         * SCROLL IMAGE GROUP
         * This calls the VBox and ScrollPane in the scene created in the fxml folder and
         * sets them as the default VBox and ScrollPane to use for imageView loop
         */
        scrollVBox = (VBox) scene.lookup("#scrollVBox");
        scrollPane = (ScrollPane) scene.lookup("#scrollPane");
        pleaseBrowseText = (Text) scene.lookup("#imageViewMainText");
        toggleButton = (ToggleButton) scene.lookup("#toggleBoundsButton");
        toggleButton.setSelected(false);
        toggleButton.setStyle("-fx-border-color: #ff1a23; -fx-border-radius: 2; -fx-border-width: 2;");

        /**
         * RUBBERBAND SELECTION
         * Makes a new rubber band selection on the image layer
         * */
        rubberBandSelection = new RubberBandSelection(imageLayer, imageViewMain);

        /**
         *
         */
        isCleared = true;

        /**
         * BROWSE BUTTON (Image folder selector)
         * Button function to browse for a file
         */
        Button browseBtn = (Button) scene.lookup("#browse"); //calls the browse button from the fxml file

        browseBtn.setOnAction(event -> {
            openDirectoryChooser(primaryStage);
        });

        /**
         * CLEAR BUTTON
         * Clears the list of images
         */
        Button clearBtn = (Button) scene.lookup("#clear");

        clearBtn.setOnAction(event -> {
            if (imageViewMain.getImage() == null || excelFile == null) {
                Popup clearNoPicturePopup = new Popup(); //creates new popup

                TitledPane clearNoPicturePopupPane = null; //calls popup menu created in 'clearNoPicturePopUp.fxml' file

                try {
                    clearNoPicturePopupPane = FXMLLoader.load(getClass().getResource("clearNoPicturePopUp.fxml"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                clearNoPicturePopup.getContent().add(clearNoPicturePopupPane); //adds the popup (child) created in fxml file to the popup (parent) created

                //show popup on primaryStage
                clearNoPicturePopup.show(primaryStage);

                System.out.println("\nCannot Clear! There is no data selected.");

                Button toggleDismissBtn = (Button) clearNoPicturePopupPane.lookup("#clearDismissBtn");
                toggleDismissBtn.setOnAction(clearDismissEvent -> {
                    try {
                        clearNoPicturePopup.hide();
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                });
            } else {
                Popup clearPopup = new Popup(); //creates new popup

                TitledPane clearPopupPane = null; //calls popup menu created in 'clearPopUp.fxml' file

                try {
                    clearPopupPane = FXMLLoader.load(getClass().getResource("clearPopUp.fxml"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                clearPopup.getContent().add(clearPopupPane); //adds the popup (child) created in fxml file to the popup (parent) created

                //show popup on primaryStage
                clearPopup.show(primaryStage);

                System.out.println("\nAre you sure you want to clear all data?");

                /*************Handle popup actions****************
                 * Button actions when the pop up window is called.
                 *************************************************/

                /**
                 * Yes CLEAR POPUP BUTTON
                 * this button clears the data
                 */
                Button clearYesBtn = (Button) clearPopupPane.lookup("#clearYesBtn");
                clearYesBtn.setOnAction(clearYesEvent -> {
                    clear();
                    try {
                        clearPopup.hide();
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                    openDirectoryChooser(primaryStage);
                });

                /**
                 * NO CLEAR POPUP BUTTON
                 * cancels the pop up action
                 */
                Button saveNoBtn = (Button) clearPopupPane.lookup("#clearNoBtn");
                saveNoBtn.setOnAction(clearNoEvent -> {
                    try {
                        clearPopup.hide();
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                });
            }
        });

        /**
         * TOGGLE BOUNDS CHECKBOX
         * Toggles the previously saved selected bounds if there were any
         */
        toggleButton.setOnAction(event -> {
            checkToggle();
        });

        /**
         * CANCEL BUTTON
         * Opens a popup when trying to cancel/delete a picture.
         */
        Button cancelBtn = (Button) scene.lookup("#cancel"); //Calls cancel button from fxml file
        cancelBtn.setOnAction(event -> { //Creates action for cancel button on main application
            if (imageViewMain.getImage() == null || excelFile == null) {
                Popup cancelNoPicturePopup = new Popup(); //creates new popup

                TitledPane cancelNoPicturePopupPane = null; //calls popup menu created in 'cancelNoPicturePopUp.fxml' file

                try {
                    cancelNoPicturePopupPane = FXMLLoader.load(getClass().getResource("cancelNoPicturePopUp.fxml"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                cancelNoPicturePopup.getContent().add(cancelNoPicturePopupPane); //adds the popup (child) created in fxml file to the popup (parent) created

                //show popup on primaryStage
                cancelNoPicturePopup.show(primaryStage);

                System.out.println("\nCannot Cancel! There is no data selected.");

                Button toggleDismissBtn = (Button) cancelNoPicturePopupPane.lookup("#cancelDismissBtn");
                toggleDismissBtn.setOnAction(cancelDismissEvent -> {
                    try {
                        cancelNoPicturePopup.hide();
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                });
            }

            /**
             * POP UP
             *  Creates a popup if there is no bounds selection on the picture
             */
            else if(rubberBandSelection.rect.contains(0,0)) {
                try {
                    /**
                     * POP UP
                     * Creates and shows a pup up if no bounds were selected.
                     */
                    Popup popup = new Popup(); //creates new popup
                    this.popup = popup;

                    TitledPane popupPane = FXMLLoader.load(getClass().getResource("cancelNoBoundsPopUp.fxml")); //calls popup menu created in 'cancelNoBoundsPopUp.fxml' file
                    popup.getContent().add(popupPane); //adds the popup (child) created in fxml file to the popup (parent) created

                    //show popup on primaryStage
                    popup.show(primaryStage);

                    /**
                     * DISMISS POPUP BUTTON
                     * Dismisses the popup
                     */
                    Button dismissBtn = (Button) popupPane.lookup("#cancelDismissBtn");
                    dismissBtn.setOnAction(noCancelEvent -> {
                        try {
                            popup.hide();
                            System.out.println("\nPopup Dismissed");
                        } catch (Exception ex) {
                            System.out.println(ex.getMessage());
                        }
                    });
                } catch (Exception ex) {

                    System.out.println(ex.getMessage());
                }
            } else {
                try {
                    /**
                     * POP UP
                     * Creates and shows a pup up to ask the user if they really want to delete the file.
                     */
                    Popup popup = new Popup(); //creates new popup
                    this.popup = popup;

                    TitledPane popupPane = FXMLLoader.load(getClass().getResource("cancelPopUp.fxml")); //calls popup menu created in 'cancelPopUp.fxml' file
                    popup.getContent().add(popupPane); //adds the popup (child) created in fxml file to the popup (parent) created

                    //show popup on primaryStage
                    popup.show(primaryStage);

                    /*************Handle popup actions****************
                     * Button actions when the pop up window is called.
                     *************************************************/

                    /**
                     * NO CANCEL POPUP BUTTON
                     * cancels the pop up action
                     */
                    Button popUpCancel = (Button) popupPane.lookup("#cancelNoPopUp");
                    popUpCancel.setOnAction(noCancelEvent -> {
                        try {
                            popup.hide();
                            System.out.println("\nSelection Not Canceled");
                        } catch (Exception ex) {

                            System.out.println(ex.getMessage());
                        }
                    });

                    /**
                     * YES CANCEL POPUP BUTTON
                     * this button deletes the picture
                     */
                    Button popUpDelete = (Button) popupPane.lookup("#cancelYesPopUp");

                    popUpDelete.setOnAction(yesCancelEvent -> {
                        try {
                            ImageView imageViewMain = (ImageView) scene.lookup("#imageViewMain");
                            imageViewMain.setImage(null);

                            // remove old rect
                            rubberBandSelection.removeRect(rubberBandSelection.rect);

                            System.out.println("\nSelection Canceled");
                        } catch (Exception ex) {
                            System.out.println(ex.getMessage());
                        }
                        try {
                            popup.hide();
                        } catch (Exception ex) {
                            System.out.println(ex.getMessage());
                        }
                    });

                    //Prints error in console if popup will not show
                } catch (Exception ex) {
                    System.out.println("error showing popup:");
                    System.out.println(ex.toString());
                }
            }
        });

        /**
         * SAVE BUTTON FUNCTION
         * Button that saves the image
         */
        Button saveBtn = (Button) scene.lookup("#save"); //Calls the save button created in the fxml file
        saveBtn.setOnAction(event -> { //Creates an action for the save button

            /**
             * CAN SAVE A PICTURE CHECK
             * Checks to see if a picture is selected and will save the picture if so
             */
            if (imageViewMain.getImage() != null) { //if statement to check if there is a picture to save
                //ask if they are sure they want to say
                Popup savePopup = new Popup(); //creates new popup

                TitledPane savePopupPane = null; //calls popup menu created in 'savePopUp.fxml' file

                try {
                    savePopupPane = FXMLLoader.load(getClass().getResource("savePopUp.fxml"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                savePopup.getContent().add(savePopupPane); //adds the popup (child) created in fxml file to the popup (parent) created

                //show popup on primaryStage
                savePopup.show(primaryStage);

                System.out.println("\nAre you sure you want to save?");

                /*************Handle popup actions****************
                 * Button actions when the pop up window is called.
                 *************************************************/

                /**
                 * YES SAVE POPUP BUTTON
                 * saves the selection
                 */
                Button saveYesBtn = (Button) savePopupPane.lookup("#saveYesBtn");
                saveYesBtn.setOnAction(saveYesEvent -> {
                    saveImage();
                    checkToggle();
                    try {
                        savePopup.hide();
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                });

                /**
                 * NO SAVE POPUP BUTTON
                 * does not save the selection
                 */
                Button saveNoBtn = (Button) savePopupPane.lookup("#saveNoBtn");
                saveNoBtn.setOnAction(saveNoEvent -> {
                    System.out.println("\nImage Not Saved");
                    try {
                        savePopup.hide();
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                    // remove rect
                    rubberBandSelection.removeRect(rubberBandSelection.rect);
                });

                this.selectionBounds = rubberBandSelection.getBounds(); // get bounds for image crop
                crop(selectionBounds); // crop the image
            }

            /**
             * SAVE NO PICTURE POPUP
             * If no picture is selected and a user tries to save, a popup will tell them there is no picture
             */
            else if (imageViewMain.getImage() == null || excelFile == null) {
                Popup saveNoPicturePopup = new Popup(); //creates new popup

                TitledPane saveNoPicturePopupPane = null; //calls popup menu created in 'saveNoPicturePopUp.fxml' file

                try {
                    saveNoPicturePopupPane = FXMLLoader.load(getClass().getResource("saveNoPicturePopUp.fxml"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                saveNoPicturePopup.getContent().add(saveNoPicturePopupPane); //adds the popup (child) created in fxml file to the popup (parent) created

                //show popup on primaryStage
                saveNoPicturePopup.show(primaryStage);

                System.out.println("\nCannot save! There is no selected image.");

                Button saveDismissBtn = (Button) saveNoPicturePopupPane.lookup("#saveDismissBtn");
                saveDismissBtn.setOnAction(saveDismissEvent -> {
                    try {
                        saveNoPicturePopup.hide();
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                });

                // remove rect
                rubberBandSelection.removeRect(rubberBandSelection.rect);
            }
        });
    }

    /**
     * DIRECTORY CHOOSER FOR MULTI IMAGES
     * lets you open a folder with multiple images
     *
     * @param parent
     */
    private void openDirectoryChooser(Stage parent) {
        if (isCleared) {
            DirectoryChooser directoryChooser = new DirectoryChooser();
            File selectedDirectory = directoryChooser.showDialog(parent);

            boolean check = new File(selectedDirectory + "\\images").exists();

            if (selectedDirectory != null && check) {

                FilenameFilter filterImage = new FilenameFilter() {
                    @Override
                    public boolean accept(File dir, String name) {
                        return name.toLowerCase().endsWith(".jpg") || name.toLowerCase().endsWith(".png") || name.toLowerCase().endsWith(".jfif");
                    }
                };

                excelFile = new File(selectedDirectory + "\\labels.csv");
                filesImage = new File(selectedDirectory + "\\images").listFiles(filterImage);
                addToScrollPane();

                System.out.println("\nExcel File Found or Created!");

                // open first image when app starts
                if (imagesSource == null) {
                    imagesSource = imageViews[0];
                }
                imageViewMain.setImage(imagesSource.getImage());
                pleaseBrowseText.setText(null);
                imageName = filesImage[0].getName(); //make the imageName

                if (filesImage != null) {
                    System.out.println("\nImages Folder Found! Images Selected.");
                    System.out.println("\nImage Selected: " + imageName + " (Image Number " + 1 + ")");
                }

                isCleared = false;
            }

            /**
             * BROWSE POPUP
             * If no images file is found, a popup will tell them there is no images file
             */
            else if (selectedDirectory != null) {
                Popup browsePopup = new Popup(); //creates new popup

                TitledPane browseFailedPopupPane = null; //calls popup menu created in 'browsePopUp.fxml' file

                try {
                    browseFailedPopupPane = FXMLLoader.load(getClass().getResource("browsePopUp.fxml"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                browsePopup.getContent().add(browseFailedPopupPane); //adds the popup (child) created in fxml file to the popup (parent) created

                //show popup on primaryStage
                browsePopup.show(primaryStage);

                System.out.println("\nImages Folder Not Found");

                Button browseDismissBtn = (Button) browseFailedPopupPane.lookup("#browseDismissBtn");
                browseDismissBtn.setOnAction(browseDismissEvent -> {
                    try {
                        browsePopup.hide();
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                });
            }
        } else {
            Popup browseErrorPopup = new Popup(); //creates new popup

            TitledPane browseErrorPopupPane = null; //calls popup menu created in 'browseErrorPopUp.fxml' file

            try {
                browseErrorPopupPane = FXMLLoader.load(getClass().getResource("browseErrorPopUp.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            browseErrorPopup.getContent().add(browseErrorPopupPane); //adds the popup (child) created in fxml file to the popup (parent) created

            //show popup on primaryStage
            browseErrorPopup.show(primaryStage);

            System.out.println("\nAre you sure you want to save?");

            /*************Handle popup actions****************
             * Button actions when the pop up window is called.
             *************************************************/

            /**
             * CLEAR AND BROWSE POPUP BUTTON
             * saves the selection
             */
            Button browseClearBtn = (Button) browseErrorPopupPane.lookup("#browseClearBtn");
            browseClearBtn.setOnAction(browseClearEvent -> {
                clear();
                checkToggle();
                try {
                    browseErrorPopup.hide();
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
                // remove rect
                rubberBandSelection.removeRect(rubberBandSelection.rect);
            });

            /**
             * DISMISS BROWSE POPUP BUTTON
             * does not save the selection
             */
            Button browseDismissBtn = (Button) browseErrorPopupPane.lookup("#browseDismissBtn");
            browseDismissBtn.setOnAction(browseDismissEvent -> {
                try {
                    browseErrorPopup.hide();
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            });
        }
    }

    /**
     * ADD IMAGES TO SCROLL PANE
     */
    public void addToScrollPane() {
        numOfImages = filesImage.length;
        images = new Image[numOfImages];
        bufferedImage = new BufferedImage[numOfImages];
        imageViews = new ImageView[numOfImages];

        for (int i = 0; i < numOfImages; i++) {
            try {
                File selectedImagesFile = filesImage[i];
                int index = i;

                bufferedImage[i] = ImageIO.read(selectedImagesFile);
                images[i] = SwingFXUtils.toFXImage(bufferedImage[i], null);
                imageViews[i] = new ImageView();
                imageNumber = i + 1;
                imageName = filesImage[i].getName();
                String imagePressed = "Image Selected: " + imageName + " (Image Number " + imageNumber + ")";

                /**
                 * IMAGE SCROLL SELECTION
                 * Lets you select on of the images in the scroll pane to edit
                 */
                imageViews[i].addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
                    // remove old rectangle
                    rubberBandSelection.removeRect(rubberBandSelection.rect);

                    imageName = filesImage[index].getName();
                    checkToggle();
                    imagesSource = (ImageView) event.getSource();
                    System.out.println("\n" + imagePressed);
                    pleaseBrowseText.setText(null);
                    imageViewMain.setImage(imagesSource.getImage());

                    event.consume();
                });

                imageViews[i].setImage(images[i]);
                imageViews[i].setFitWidth(155);
                imageViews[i].setFitHeight(75);
                imageViews[i].setPreserveRatio(false);
                imageViews[i].setSmooth(true);
                imageViews[i].setCache(true);

                scrollVBox.getChildren().addAll(imageViews[i]);
                scrollVBox.setSpacing(10);
                scrollVBox.requestLayout();
                scrollPane.requestLayout();
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        this.csv = excelFile.getAbsolutePath();
        if (!hasBeenRead) {
            previousData = csvReadWrite.readCsv(csv); //Reads the Csv file (so it does not overwrite entire file)
            hasBeenRead = true;
        }

        System.out.println("\nNumber of Images " + numOfImages);
    }

    /**
     * CLEAR EVERYTHING
     * Clears all data
     */
    public void clear() {
        try {
            rubberBandSelection.removeRect(rubberBandSelection.rect);
            rubberBandSelection.removeRect(rubberBandSelection.prevSelection);
            scrollVBox.getChildren().clear();
            excelFile = null;
            imageViewMain.setImage(null);
            selectionBounds = null;
            numOfImages = 0;
            previousData = null;
            imageViews = null;
            csvReadWrite = new CsvReadWrite();
            imagesSource = null;
            imageName = null;
            csv = null;
            hasBeenRead = false;
            filesImage = null;
            images = null;
            bufferedImage = null;
            imageNumber = 0;
            isCleared = true;
            pleaseBrowseText.setText("Please Browse for a Photo to Edit");
            System.out.println("\nThe selected images and the Excel file have been cleared");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * TOGGLE BOUNDS CHECKBOX
     * Toggles the previously saved selected bounds if there were any
     */
    public void checkToggle() {
        if (toggleButton.isSelected()) {
            if (imageViewMain.getImage() == null || excelFile == null) {
                Popup toggleNoPicturePopup = new Popup(); //creates new popup

                TitledPane toggleNoPicturePopupPane = null; //calls popup menu created in 'toggleNoPicturePopUp.fxml' file

                try {
                    toggleNoPicturePopupPane = FXMLLoader.load(getClass().getResource("toggleNoPicturePopUp.fxml"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                toggleNoPicturePopup.getContent().add(toggleNoPicturePopupPane); //adds the popup (child) created in fxml file to the popup (parent) created

                //show popup on primaryStage
                toggleNoPicturePopup.show(primaryStage);

                System.out.println("\nCannot Show Previous Bounds! There is no image selected.");

                Button toggleDismissBtn = (Button) toggleNoPicturePopupPane.lookup("#toggleDismissBtn");
                toggleDismissBtn.setOnAction(toggleDismissEvent -> {
                    try {
                        toggleNoPicturePopup.hide();
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                });

                toggleButton.setSelected(false);
                toggleButton.setStyle("-fx-border-color: #ff1a23; -fx-border-radius: 2; -fx-border-width: 2;");
            } else {
                toggleButton.setStyle("-fx-border-color: #06bdff; -fx-border-radius: 2; -fx-border-width: 2;");
                for (int i = 0; i < previousData.length; i++) {
                    if (previousData[i].getImageName().equals(imageName)) {
                        Rectangle r = new Rectangle();
                        r.setX(previousData[i].getSelectedX1());
                        r.setY(previousData[i].getSelectedY4());
                        r.setHeight(previousData[i].getSelectedY1() - previousData[i].getSelectedY3());
                        r.setWidth(previousData[i].getSelectedX2() - previousData[i].getSelectedX1());
                        rubberBandSelection.setPreviousRectangle(r);
                        break;
                    } else {
                        rubberBandSelection.removeRect(rubberBandSelection.prevSelection);
                    }
                }
            }
        } else if (!toggleButton.isSelected()) {
            rubberBandSelection.removeRect(rubberBandSelection.prevSelection);
            toggleButton.setStyle("-fx-border-color: #ff1a23; -fx-border-radius: 2; -fx-border-width: 2;");
        }
    }

    /**
     * SAVE BOUNDS TO CSV FILE
     * Writes bounds selected to a csv file
     */
    public void saveImage() {
        System.out.println("\nSelected area: " + selectionBounds); // show bounds info

        int index = java.util.Arrays.asList(imageViews).indexOf(imagesSource);
        imageName = filesImage[index].getName(); //make the imageName

        int i;
        boolean found = false;
        for (i = 0; i < previousData.length; i++) {
            if (previousData[i] == null) {
                found = false;
                break;
            } else if (previousData[i].getImageName().equals(imageName)) {
                previousData[i] = addPreviousData(previousData[i]);
                found = true;
            }
        }

        i--;
        if (!found) {
            previousData[i] = addPreviousData(previousData[i]);
        }

        csvReadWrite.add(previousData[i]);
        csvReadWrite.writeCsv(csv);

        System.out.println("\n" + imageName + " saved");
    }

    /**
     * ADD PREVIOUS DATA
     * Reads all information from CSV file into list
     */
    public LabelData addPreviousData(LabelData ld) {
        ld = new LabelData();

        ld.setImageName(this.imageName);
        ld.setSelectedX1(selectionBounds.getMinX()); //X1
        ld.setSelectedY1(selectionBounds.getMaxY()); //Y1
        ld.setSelectedX2(selectionBounds.getMaxX()); //X2
        ld.setSelectedY2(selectionBounds.getMaxY()); //Y2
        ld.setSelectedX3(selectionBounds.getMinX()); //X3
        ld.setSelectedY3(selectionBounds.getMinY()); //Y3
        ld.setSelectedX4(selectionBounds.getMaxX()); //X4
        ld.setSelectedY4(selectionBounds.getMinY()); //Y4

        return ld;
    }

    /**
     * CROPPING METHOD
     * method for cropping and saving the image
     *
     * @param bounds
     */
    public void crop(Bounds bounds) {
        int width = (int) bounds.getWidth();
        int height = (int) bounds.getHeight();

        SnapshotParameters parameters = new SnapshotParameters();
        parameters.setFill(Color.TRANSPARENT);
        parameters.setViewport(new Rectangle2D(bounds.getMinX(), bounds.getMinY(), width, height));

        WritableImage wi = new WritableImage(width, height);
        imageViewMain.snapshot(parameters, wi);

        // save image (without alpha)
        BufferedImage bufImageARGB = SwingFXUtils.fromFXImage(wi, null);
        BufferedImage bufImageRGB = new BufferedImage(bufImageARGB.getWidth(), bufImageARGB.getHeight(), BufferedImage.OPAQUE);

        Graphics2D graphics = bufImageRGB.createGraphics();
        graphics.drawImage(bufImageARGB, 0, 0, null);

        graphics.dispose();
    }

    /**
     * Runs the program
     *
     * @param args
     */
    public static void main(String... args) {
        Application.launch(args);
    }
}