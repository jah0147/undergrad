package sample;

import java.io.File;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;
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
import javafx.application.Platform;


public class CancelPopUp extends Main {
	
	public void start(Stage popupStage) throws Exception {
		System.out.println("setup window");
		TitledPane titled = FXMLLoader.load(getClass().getResource("../../../Image Cropping Tool/src/CancelPopUp.fxml"));

		Scene scene = new Scene(titled,100, 100);
		popupStage.setScene(scene);
		popupStage.show();
		popupStage.setAlwaysOnTop(true); //set to false to show alerts
		popupStage.setResizable(false); //makes app unable to be resized

		//Cancel button in popup
                Button popUpCancel = (Button)scene.lookup("#cancelPopUp");
                popUpCancel.setOnAction((event) -> {
                	try {
						System.out.println("try hide");
						popupStage.hide();
					}
					catch(Exception ex) {
						System.out.println(ex.getMessage());
					}
                });

		popupStage.showAndWait();


	}
	
	public static void main(String... args) {
		Application.launch(args);
	}

}
