package sample;

import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Popup;
//import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.Scene;
//import javafx.scene.layout.BorderPane;
//import javafx.scene.layout.GridPane;
//import javafx.scene.layout.HBox;
import javafx.scene.layout.GridPane;
//import javafx.scene.control.Label;
//import javafx.scene.control.TextField;
//import javafx.scene.control.ComboBox;
//import javafx.scene.control.TableView;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TitledPane;

import javax.imageio.ImageIO;
import java.awt.*;
//import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.util.ResourceBundle;
//import java.io.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Main extends Application {

    @FXML // fx:id="imageView"
    private ImageView imageView; // Value injected by FXMLLoader

    @FXML
    private Image imageViewSource;

    @FXML // fx:id="browse"
    private Button browse; // Value injected by FXMLLoader

    @FXML // fx:id="cancel"
    private Button cancel; // Value injected by FXMLLoader

    @FXML // fx:id="save"
    private Button save; // Value injected by FXMLLoader

    //Variables
    private File selectedFile;
    private File saveFile;



    //Displays chosen image


    //The GUI interface scene
    @Override
    public void start(Stage primaryStage) throws Exception {
        TitledPane titled = FXMLLoader.load(getClass().getResource("GUI.fxml"));

        Scene scene = new Scene(titled);

//        Group group = new Group();
//        group.getChildren().addAll(imageView);

        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setAlwaysOnTop(false); //set to false to show alerts
        primaryStage.setResizable(false); //makes app unable to be resized



//        ImageView imagePreview = (ImageView)scene.lookup("#imageView");
//        Image img = new Image(selectedFile.toAbsolutePath());
//        imagePreview.setImage(img);

// selected file from browse variable


        //Invokes a browser menue when the browse button is pressed

        /**
         * BROWSE BUTTON
         * Button function to browse for a file
         */
        Button browseBtn = (Button)scene.lookup("#browse");

        browseBtn.setOnAction((event) -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Open Resource File");

            //gets the user selected files path
            selectedFile = fileChooser.showOpenDialog(primaryStage);
            String filePath = "file:" + selectedFile.getAbsolutePath();
            System.out.println(filePath);

            ImageView imageView = (ImageView)scene.lookup("#imageView");
            Image image = new Image(filePath);
            imageView.setImage(image);

//            Node image = (Node)scene.lookup("#imageViewSource");
//            image.setId(selectedFile.getAbsolutePath());

        });

        /**
         * SAVE BUTTON FUNCTION
         * Button that saves the image
         */
        Button saveBtn = (Button)scene.lookup("#save");



/**
 //saveBtn.setOnAction((event) -> {
//            FileChooser fileChooser = new FileChooser();
//
//            //Set extension filter
//            FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Picture files (*.png)", "*.png");
//            fileChooser.getExtensionFilters().add(extFilter);
//
//            //Show save file dialog
//            File saveFile = fileChooser.showSaveDialog(primaryStage);
//
//            if(saveFile != null){
//                saveFile(selectedFile, saveFile);
//            }
//
//        });
 */

        /**
         * CANCEL BUTTON
         * Opens a popup when trying to cancel/delete a picture.
         */
        Button cancelBtn = (Button)scene.lookup("#cancel");
        cancelBtn.setOnAction((event) -> {
            try {


                /**
                 * POP UP
                 * Creates and shows a pup up to ask the user
                 * if they really want to delete the file.
                 */
                Popup popup = new Popup();
                TitledPane popupPane = FXMLLoader.load(getClass().getResource("CancelPopUp.fxml"));
                popup.getContent().add(popupPane);

                //show popup
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
                        imageView.setImage(deleteImage);
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
}
