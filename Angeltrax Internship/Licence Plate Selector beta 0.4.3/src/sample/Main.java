package sample;

import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Bounds;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.shape.StrokeLineCap;
import javafx.stage.*;

import static javafx.stage.Modality.APPLICATION_MODAL;

import javafx.scene.Scene;
import javafx.fxml.FXML;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.scene.SnapshotParameters;
import javafx.scene.image.WritableImage;
import javafx.event.EventHandler;



public class Main extends Application {

    @FXML // fx:id="imageView"
    private ImageView imageViewMain; // Value injected by FXMLLoader

    @FXML
    private ImageView imageViewScroll1;

    @FXML
    private Image imageViewSource;

    @FXML // fx:id="removeCrop"
    private Button removeCrop; // Value injected by FXMLLoader

    @FXML // fx:id="browse"
    private Button browse; // Value injected by FXMLLoader

    @FXML // fx:id="cancel"
    private Button cancel; // Value injected by FXMLLoader

    @FXML // fx:id="save"
    private Button save; // Value injected by FXMLLoader

    @FXML
    private Button clear;

    @FXML // fx:id="savePopup"
    private TitledPane savePopup; // Value injected by FXMLLoader

    @FXML // fx:id="saveDismissBtn"
    private Button saveDismissBtn; // Value injected by FXMLLoader

    @FXML
    VBox scrollVBox;

    @FXML
    public ScrollPane scrollPane;

    //Variables
    private File selectedFile;
    private File saveFile;
    private String filePath;
    public Image selectedImage;
    Stage primaryStage;
    RubberBandSelection rubberBandSelection;
    Popup popup = null;
    private String imageViewScroll;
    File filesImage[];
    Image images[];
    ImageView imageViews[];
    BufferedImage bufferedImage[];
    Group scrollImageViewGroup;
    String imageFilePath;
    public ImageView imagesSource;




    //Displays chosen image


    //The GUI interface scene
    @Override
    public void start(Stage primaryStage) throws Exception {

        this.primaryStage = primaryStage; //sets this primaryStage as 'the' primaryStage
        TitledPane titled = FXMLLoader.load(getClass().getResource("GUI.fxml")); //Calls the TitledPane from the fxml file

        /**
         * MAIN STAGE CREATED
         * Main Stage and Scene Created and shown
         */
        Scene scene = new Scene(titled); //creates a mew scene from the TitlesPane created in 'GUI.fxml'
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
        Group imageLayer = (Group)scene.lookup("#imageLayer"); //calls the group created from the fxml file
        imageViewMain = new ImageView(selectedImage); //creates new imageView container for the group
        imageLayer.getChildren().addAll(imageViewMain); //puts the imageView in the group so it can be edited

        /**
         * SCROLL IMAGE GROUP
         * This calls the VBox and ScrollPane in the scene created in the fxml folder and
         * sets them as the default VBox and ScrollPane to use for imageView loop
         */
        this.scrollImageViewGroup = (Group)scene.lookup("#scrollImageViewGroup");
        this.scrollVBox = (VBox)scene.lookup("#scrollVBox");
        this.scrollPane = (ScrollPane)scene.lookup("#scrollPane");

        /**
         * RUBBERBAND SELECTION
         * Makes a new rubber band selection on the image layer
         * */
        RubberBandSelection rubberBandSelection;
        rubberBandSelection = new RubberBandSelection(imageLayer);

        /**
         * BROWSE BUTTON
         * Button function to browse for a file
         */
        Button browseBtn = (Button)scene.lookup("#browse"); //calls the browse button from the fxml file

        browseBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                openDirectoryChooser(primaryStage);
            }
        });

        this.imageViewMain = (ImageView)scene.lookup("#imageViewMain"); //calls the imageView from the fxml file

        //OLD BROWSE BUTTON FEATURE
//        browseBtn.setOnAction((event) -> {
//            FileChooser fileChooser = new FileChooser();
//            fileChooser.setTitle("Open Resource File");
//
//            //gets the user selected files path
//            selectedFile = fileChooser.showOpenDialog(primaryStage);
//            this.filePath = "file:" + selectedFile.getAbsolutePath();
//            System.out.println(filePath);
//            int scrollNumberCode = 1;
//            String scrollNumber = "#imageViewScroll" + scrollNumberCode;
//            ImageView imageViewScroll = (ImageView)scene.lookup("" + scrollNumber);
//            ImageView noImage = new ImageView("file:");
//
//

//            selectedImage = new Image(filePath);
//            imageViewMain.setImage(selectedImage);
//
//
//            //Makes the imageView with the selected image the default image view (important for cropping the image)
//            this.imageViewMain = imageViewMain;
//        }); //Sets action for the browse button. Opens a browse file menu

        /**
         * CLEAR BUTTON
         * Clears the list of images
         */
        Button clearBtn = (Button)scene.lookup("#clear");

        clearBtn.setOnAction((event) -> {
         try {
             scrollVBox.getChildren().clear();
         }

         catch(Exception ex) {

             System.out.println(ex.getMessage());
         }
        });

        /**
         * CROP PHOTO (by right click) edited out
         * This is a right click menu if the user would rather right click
         * the cropped photo to save it.
         *
         * **********************************************************************************
         *
         *      ContextMenu contextMenu = new ContextMenu();
         *
         *         javafx.scene.control.MenuItem cropMenuItem = new MenuItem("Crop Image");
         *         cropMenuItem.setOnAction(new EventHandler<ActionEvent>() {
         *             public void handle(ActionEvent e) {
         *
         *                 // get bounds for image crop
         *                 Bounds selectionBounds = rubberBandSelection.getBounds();
         *
         *                 // show bounds info
         *                 System.out.println("Selected area: " + selectionBounds);
         *
         *                 // crop the image
         *                 crop(selectionBounds);
         *
         *             }
         *         });
         *         contextMenu.getItems().add(cropMenuItem);
         *
         *         // set context menu on image layer
         *         imageLayer.setOnMousePressed(new EventHandler<MouseEvent>() {
         *             @Override
         *             public void handle(MouseEvent event) {
         *                 if (event.isSecondaryButtonDown()) {
         *                     contextMenu.show(imageLayer, event.getScreenX(), event.getScreenY());
         *                 }
         *             }
         *         });
         ***************************************************************************************************
         *
         */

        /**
         * SAVE BUTTON FUNCTION
         * Button that saves the image
         */
        Button saveBtn = (Button)scene.lookup("#save"); //Calls the save button created in the fxml file
        saveBtn.setOnAction((event) -> { //Creates an action for the save button
            try {

                /**
                 * CAN SAVE A PICTURE CHECK
                 * Checks to see if a picture is selected and will save the picture if so
                 */
                if (imagesSource != null) { //if statement to check if there is a picture to save
                    Bounds selectionBounds = rubberBandSelection.getBounds(); // get bounds for image crop

                    System.out.println("Selected area: " + selectionBounds); // show bounds info

                    crop(selectionBounds); // crop the image

                    System.out.println("File Saved or Canceled ");
                }
                /**
                 * SAVE POPUP
                 * If not picture is selected and a user tries to save, a popup will tell them there is no picture
                 */
                else {
                    if (imagesSource == null) {
                        Popup savePopup = new Popup(); //creates new popup

                        TitledPane savePopupPane = FXMLLoader.load(getClass().getResource("savePopUp.fxml")); //calls popup menu created in 'CancelPopUp.fxml' file
                        savePopup.getContent().add(savePopupPane); //adds the popup (child) created in fxml file to the popup (parent) created

                        //show popup on primaryStage
                        savePopup.show(primaryStage);

                        System.out.println("Cannot save! There is no selected image.");

                        Button saveDismissBtn = (Button)savePopupPane.lookup("#saveDismissBtn");
                        saveDismissBtn.setOnAction((saveDismissEvent) -> {
                            try {
                                savePopup.hide();
                                System.out.println("save popup hidden");
                            }
                            catch(Exception ex) {

                                System.out.println(ex.getMessage());
                            }
                        });
                    }
                }
            }
            catch (Exception ex) {
                System.out.println("error saving "); //If there is an error saving/canceling the file, prints this message
                System.out.println(ex.toString());
            }
        });

        /**
         * CANCEL BUTTON
         * Opens a popup when trying to cancel/delete a picture.
         */
        Button cancelBtn = (Button)scene.lookup("#cancel"); //Calls cancel button from fxml file
        cancelBtn.setOnAction((event) -> { //Creates action for cancel button on main application
            try {
                /**
                 * POP UP
                 * Creates and shows a pup up to ask the user if they really want to delete the file.
                 */
                Popup popup = new Popup(); //creates new popup
                this.popup = popup;

                TitledPane popupPane = FXMLLoader.load(getClass().getResource("CancelPopUp.fxml")); //calls popup menu created in 'CancelPopUp.fxml' file
                popup.getContent().add(popupPane); //adds the popup (child) created in fxml file to the popup (parent) created

                //show popup on primaryStage
                popup.show(primaryStage);

                /*************Handle popup actions****************
                 * Button actions when the pop up window is called.
                 *************************************************/

                /**
                 * CANCEL POPUP BUTTON
                 * cancels the pop up action
                 */
                Button popUpCancel = (Button)popupPane.lookup("#cancelPopUp");
                popUpCancel.setOnAction((popCancelEvent) -> {
                    try {
                        popup.hide();
                        System.out.println("Canceled");
                    }
                    catch(Exception ex) {

                        System.out.println(ex.getMessage());
                    }
                });

                /**
                 * DELETE POPUP BUTTON
                 * this button deletes the picture
                 */
                Button popUpDelete = (Button)popupPane.lookup("#deletePopUp");
                Node image = (Node)titled.lookup("#imageViewSource");

                popUpDelete.setOnAction((popDeleteEvent) -> {
                    try {
                        ImageView imageViewMain = (ImageView)scene.lookup("#imageViewMain");
                        Image deleteImage = new Image("file:");
                        imageViewMain.setImage(null);
                        selectedImage = null;
                        imagesSource = null;
                        System.out.println("Image Deleted");
                    }
                    catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                    try {
                        popup.hide();
                    }
                    catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                });

                //Prints error in console if popup will not show
            } catch(Exception ex) {
                System.out.println("error showing popup::");
                System.out.println(ex.toString());
            }

        });

    }

    /**
     * Runs the program
     * @param args
     */
    public static void main(String... args) {
        Application.launch(args);
    }

    /**
     * DRAG SELECTION
     * Drag rectangle with mouse cursor in order to get selection bounds.
     */
    public class RubberBandSelection {

        final DragContext dragContext = new DragContext();
        Rectangle rect = new Rectangle();

        Group rubberBandGroup;


        public Bounds getBounds() {
            return rect.getBoundsInParent();
        }

        public RubberBandSelection(Group group) {

            this.rubberBandGroup = group;

            rect = new Rectangle(0, 0, 0, 0);
            rect.setStroke(Color.GOLD);
            rect.setStrokeWidth(1);
            rect.setStrokeLineCap(StrokeLineCap.ROUND);
            rect.setFill(Color.GRAY.deriveColor(0, 1.2, 1, 0.6));

            group.addEventHandler(MouseEvent.MOUSE_PRESSED, onMousePressedEventHandler);
            group.addEventHandler(MouseEvent.MOUSE_DRAGGED, onMouseDraggedEventHandler);
            group.addEventHandler(MouseEvent.MOUSE_RELEASED, onMouseReleasedEventHandler);

        }

        EventHandler<MouseEvent> onMousePressedEventHandler = new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {

                if(imageViewMain.getImage() == null) {
                    System.out.println("No Image to select bounds");
                    return;
                }

                if( event.isSecondaryButtonDown())
                    return;

                // remove old rect
                rect.setX(0);
                rect.setY(0);
                rect.setWidth(0);
                rect.setHeight(0);

                rubberBandGroup.getChildren().remove(rect);


                // prepare new drag operation
                dragContext.mouseAnchorX = event.getX();
                dragContext.mouseAnchorY = event.getY();

                rect.setX(dragContext.mouseAnchorX);
                rect.setY(dragContext.mouseAnchorY);
                rect.setWidth(0);
                rect.setHeight(0);

                rubberBandGroup.getChildren().add(rect);

            }
        };

        EventHandler<MouseEvent> onMouseDraggedEventHandler = new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                if(imageViewMain.getImage() == null) {
                    return;
                }

                // check if the mouseevent coordinates are outside the bounds of the image view then cancel
                if(!imageViewMain.getBoundsInParent().contains(event.getX(), event.getY())) {
                    return;
                }

                if( event.isSecondaryButtonDown())
                    return;

                double offsetX = event.getX() - dragContext.mouseAnchorX;
                double offsetY = event.getY() - dragContext.mouseAnchorY;

                if( offsetX > 0)
                    rect.setWidth( offsetX);
                else {
                    rect.setX(event.getX());
                    rect.setWidth(dragContext.mouseAnchorX - rect.getX());
                }

                if( offsetY > 0) {
                    rect.setHeight( offsetY);
                } else {
                    rect.setY(event.getY());
                    rect.setHeight(dragContext.mouseAnchorY - rect.getY());
                }
            }
        };


        EventHandler<MouseEvent> onMouseReleasedEventHandler = new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {

                if(imageViewMain.getImage() == null) {

                    rect.setX(0);
                    rect.setY(0);
                    rect.setWidth(0);
                    rect.setHeight(0);

                    rubberBandGroup.getChildren().remove(rect);

                    return;
                }

                if (event.isSecondaryButtonDown())
                    return;

                // remove rectangle
                // note: we want to keep the ruuberband selection for the cropping => code is just commented out

                if (imageViewMain.getImage() == null) {
//                    rect.setX(0);
//                    rect.setY(0);
//                    rect.setWidth(0);
//                    rect.setHeight(0);
//
//                    rubberBandGroup.getChildren().remove(rect);
                }
            }
        };
        private final class DragContext {

            public double mouseAnchorX;
            public double mouseAnchorY;


        }
    }

    /**
     * CROPPING METHOD
     * method for cropping and saving the image
     * @param bounds
     */
    public void crop(Bounds bounds) {

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save Image");

        File file = fileChooser.showSaveDialog(primaryStage);
        if (file == null)
            return;

        int width = (int) bounds.getWidth();
        int height = (int) bounds.getHeight();

        SnapshotParameters parameters = new SnapshotParameters();
        parameters.setFill(Color.TRANSPARENT);
        parameters.setViewport(new Rectangle2D( bounds.getMinX(), bounds.getMinY(), width, height));

        WritableImage wi = new WritableImage( width, height);
        imageViewMain.snapshot(parameters, wi);

        /**save image
         *  has bug because of transparency (use approach below) !!!
         *********************************************************************/
//        try {
//          ImageIO.write(SwingFXUtils.fromFXImage( wi, null), "jpg", file);
//      } catch (IOException e) {
//          e.printStackTrace();
//      }


        // save image (without alpha)
        // --------------------------------
        BufferedImage bufImageARGB = SwingFXUtils.fromFXImage(wi, null);
        BufferedImage bufImageRGB = new BufferedImage(bufImageARGB.getWidth(), bufImageARGB.getHeight(), BufferedImage.OPAQUE);

        Graphics2D graphics = bufImageRGB.createGraphics();
        graphics.drawImage(bufImageARGB, 0, 0, null);

        try {

            ImageIO.write(bufImageRGB, "png", file);

            System.out.println( "Image saved to " + file.getAbsolutePath());

        } catch (IOException e) {
            e.printStackTrace();
        }

        graphics.dispose();

    }


    /**
     * DIRECTORY CHOOSER FOR MULTI IMAGES
     * lets you open a folder with multiple images
     * @param parent
     */
    private void openDirectoryChooser(Stage parent) {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        File selectedDirectory =
                directoryChooser.showDialog(parent);

        if (selectedDirectory != null) {
            FilenameFilter filterImage = new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    return name.toLowerCase().endsWith(".jpg") || name.toLowerCase().endsWith(".png") || name.toLowerCase().endsWith(".jfif");
                }
            };

            filesImage = selectedDirectory.listFiles(filterImage);
            addToScrollPane();
        }
    }

    /**
     * OPEN IMAGES IN SCROLL PANE
     */
    public void addToScrollPane() {
        int numOfImages = filesImage.length;
        images = new Image[numOfImages];
        bufferedImage = new BufferedImage[numOfImages];
        imageViews = new ImageView[numOfImages];
        //titledPanes = new TitledPane[numOfJpg];
        //scrollVBox = new VBox(numOfJpg);

        for (int i = 0; i < numOfImages; i++) {
            try {
                File selectedImagesfile = filesImage[i];

                bufferedImage[i] = ImageIO.read(selectedImagesfile);
                images[i] = SwingFXUtils.toFXImage(bufferedImage[i], null);
                imageViews[i] = new ImageView();
                String imagePressed = "Tile pressed " + i;

                /**
                 * IMAGE SCROLL SELECTION
                 * Lets you select on of the images in the scroll pane to edit
                 */
                imageViews[i].addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

                    @Override
                    public void handle(MouseEvent event) {
                        imagesSource = (ImageView)event.getSource();
                        System.out.println(imagePressed);
                        imageViewMain.setImage(imagesSource.getImage());

                            event.consume();
                        }

                });
                imageViews[i].setFitHeight(100);

                imageViews[i].setImage(images[i]);
                imageViews[i].setFitWidth(130);
                imageViews[i].setFitHeight(50);
                imageViews[i].setPreserveRatio(false);
                imageViews[i].setSmooth(true);
                imageViews[i].setCache(true);
                //scrollVBox = new VBox(imageViews[i]);


                scrollVBox.getChildren().addAll(imageViews[i]);
                scrollVBox.setSpacing(10);
                scrollVBox.requestLayout();
                scrollPane.requestLayout();
                //scrollVBox.setAlignment(Pos.CENTER);
                System.out.println("number of images " + (i + 1));
                System.out.println(imageFilePath);
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }



        }
//        Accordion accordion = new Accordion();
//        accordion.getPanes().addAll(titledPanes);

//        Stage titledPaneStage = new Stage();
//        titledPaneStage.setTitle("TitledPane");
        //Scene scene = new Scene(new Group(), 400, 400);

        //scrollImageViewGroup.getChildren().add(scrollVBox);
//        titledPaneStage.setScene(scene);
//        titledPaneStage.show();
    }

}
