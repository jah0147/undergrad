package sample;

import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Bounds;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Node;
//import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.Button;
//import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
//import javafx.scene.layout.Pane;
//import javafx.scene.layout.StackPane;
import javafx.scene.shape.StrokeLineCap;
//import javafx.scene.web.WebEngine;
//import javafx.scene.web.WebView;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Popup;
//import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.Scene;
//import javafx.scene.layout.BorderPane;
//import javafx.scene.layout.GridPane;
//import javafx.scene.layout.HBox;
//import javafx.scene.layout.GridPane;
//import javafx.scene.control.Label;
//import javafx.scene.control.TextField;
//import javafx.scene.control.ComboBox;
//import javafx.scene.control.TableView;
import javafx.fxml.FXML;

import javax.imageio.ImageIO;
import java.awt.*;
//import java.awt.image.BufferedImage;
import java.awt.image.BufferedImage;
import java.io.File;
//import java.io.FileInputStream;
import java.io.IOException;
//import java.net.URL;
//import java.util.Collection;
//import java.util.ResourceBundle;
//import java.io.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
//import javafx.scene.input.KeyEvent;
//import javafx.scene.input.KeyCode;
import javafx.scene.SnapshotParameters;
//import javafx.scene.effect.Light.Point;
import javafx.scene.image.WritableImage;
import javafx.event.EventHandler;

public class Main extends Application {

    @FXML // fx:id="imageView"
     private ImageView imageView; // Value injected by FXMLLoader

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

    //Variables
    private File selectedFile;
    private File saveFile;
    private String filePath;
    private Image selectedImage;
    Stage primaryStage;
    RubberBandSelection rubberBandSelection;



    //Displays chosen image


    //The GUI interface scene
    @Override
    public void start(Stage primaryStage) throws Exception {

        this.primaryStage = primaryStage; //sets this primaryStage as 'the' primaryStage

        TitledPane titled = FXMLLoader.load(getClass().getResource("GUI.fxml")); //Calls the TitledPane from the fxml file

        /**
         * NEW SCENE
         */
        Scene scene = new Scene(titled); //creates a mew scene from the TitlesPane created in 'GUI.fxml'
        primaryStage.setTitle("Photo Cropping Tool"); //sets the title of the app
        primaryStage.setScene(scene); //sets the scene on the stage
        primaryStage.show(); //shows the primaryStage
        primaryStage.setAlwaysOnTop(false); //set to false to show popups
        primaryStage.setResizable(false); //makes app unable to be resized

        /**
         * IMAGE LAYER GROUP
         * New group for the image layer
         * (used so you can snapshot the current photo and crop
         */
        Group imageLayer = (Group)scene.lookup("#imageLayer"); //calls the group created from the fxml file
        imageView = new ImageView(selectedImage); //creates new imageView container for the group
        imageLayer.getChildren().addAll(imageView); //puts the imageView in the group so it can be edited

        /**
         * RUBBERBAND SELECTION
         * Makes a new rubber band selection on the image layer
         * */
        RubberBandSelection rubberBandSelection;
        rubberBandSelection = new Main.RubberBandSelection(imageLayer);

        /**
         * BROWSE BUTTON
         * Button function to browse for a file
         */
        Button browseBtn = (Button)scene.lookup("#browse"); //calls the browse button from the fxml file

        //event for the browse button
        browseBtn.setOnAction((event) -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Open Resource File");

            //gets the user selected files path
            selectedFile = fileChooser.showOpenDialog(primaryStage);
            filePath = "file:" + selectedFile.getAbsolutePath();
            System.out.println(filePath);

            ImageView imageView = (ImageView)scene.lookup("#imageView"); //calls the imageView from the fxml file
            selectedImage = new Image(filePath);
            imageView.setImage(selectedImage);

            //Makes the imageView with the selected image the default image view (important for cropping the image)
            this.imageView = imageView;
        });


        /**
         * CROP PHOTO
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
    Bounds selectionBounds = rubberBandSelection.getBounds(); // get bounds for image crop

    System.out.println("Selected area: " + selectionBounds); // show bounds info

            crop(selectionBounds); // crop the image

    System.out.print("File Saved or Canceled ");
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
                        ImageView imageView = (ImageView)scene.lookup("#imageView");
                        Image deleteImage = new Image("file:");
                        imageView.setImage(null);
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
    public static class RubberBandSelection {

        final DragContext dragContext = new DragContext();
        Rectangle rect = new Rectangle();

        Group group;


        public Bounds getBounds() {
            return rect.getBoundsInParent();
        }

        public RubberBandSelection(Group group) {

            this.group = group;

            rect = new Rectangle( 0,0,0,0);
            rect.setStroke(Color.GOLD);
            rect.setStrokeWidth(1);
            rect.setStrokeLineCap(StrokeLineCap.ROUND);
            rect.setFill(Color.LIGHTGRAY.deriveColor(0, 1.2, 1, 0.6));

            group.addEventHandler(MouseEvent.MOUSE_PRESSED, onMousePressedEventHandler);
            group.addEventHandler(MouseEvent.MOUSE_DRAGGED, onMouseDraggedEventHandler);
            group.addEventHandler(MouseEvent.MOUSE_RELEASED, onMouseReleasedEventHandler);

        }

        EventHandler<MouseEvent> onMousePressedEventHandler = new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {

                if( event.isSecondaryButtonDown())
                    return;

                // remove old rect
                rect.setX(0);
                rect.setY(0);
                rect.setWidth(0);
                rect.setHeight(0);

                group.getChildren().remove(rect);


                // prepare new drag operation
                dragContext.mouseAnchorX = event.getX();
                dragContext.mouseAnchorY = event.getY();

                rect.setX(dragContext.mouseAnchorX);
                rect.setY(dragContext.mouseAnchorY);
                rect.setWidth(0);
                rect.setHeight(0);

                group.getChildren().add(rect);

            }
        };

        EventHandler<MouseEvent> onMouseDraggedEventHandler = new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {

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

                if( event.isSecondaryButtonDown())
                    return;

                // remove rectangle
                // note: we want to keep the ruuberband selection for the cropping => code is just commented out
                /*
                rect.setX(0);
                rect.setY(0);
                rect.setWidth(0);
                rect.setHeight(0);

                group.getChildren().remove( rect);
                */

            }
        };
        private static final class DragContext {

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
        imageView.snapshot(parameters, wi);

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

            ImageIO.write(bufImageRGB, "jpg", file);

            System.out.println( "Image saved to " + file.getAbsolutePath());

        } catch (IOException e) {
            e.printStackTrace();
        }

        graphics.dispose();

    }

}
