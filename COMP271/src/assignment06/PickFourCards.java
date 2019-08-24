/*
 * Similar to the previous assignment, but it also includes a refresh button that will display new cards.
 * Exercise in buttons and event handling
 */
package assignment06;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Button;
import java.util.*;

public class PickFourCards extends Application{
	@Override
	public void start(Stage primaryStage) {

	    //Create an HBox layout.
	    Pane pane = new HBox(10);
	    pane.setPadding(new Insets(5,5,5,5));
	    //Set alignment.
	    getRandomCards(pane);
		
		Scene scene = new Scene(pane);
		primaryStage.setTitle("Pick Four Cards");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public void getRandomCards(Pane pane) {
//	Similar to last assignment, in terms of shuffling integers, creating randomized filenames, setting images into pane
// 	displaying the pane.

		// clear the Pane first before we add new things into it and set it on the scene.
	    pane.getChildren().clear();
	    pane.setPadding(new Insets(5,5,5,5));
	    
		// creates an ArrayList with Integer objects, numbers 1-52
		ArrayList<Integer> list = new ArrayList<>();
		for(int i = 1; i < 53; i++){
			list.add(i);
		}
		
		// shuffles the data and then creates a string with an appropriate image address
		java.util.Collections.shuffle(list);
		String imageString0 = "file:card/" + list.get(0) + ".png";
		String imageString1 = "file:card/" + list.get(1) + ".png";
		String imageString2 = "file:card/" + list.get(2) + ".png";
		String imageString3 = "file:card/" + list.get(3) + ".png";
		
	    //Add the images into the pane
	    Image image0 = new Image(imageString0);
		ImageView imageView0 = new ImageView(image0);
		pane.getChildren().add(imageView0);
		
		Image image1 = new Image(imageString1);
		ImageView imageView1 = new ImageView(image1);
		pane.getChildren().add(imageView1);
		
		Image image2 = new Image(imageString2);
		ImageView imageView2 = new ImageView(image2);
		pane.getChildren().add(imageView2);
		
		Image image3 = new Image(imageString3);
		ImageView imageView3 = new ImageView(image3);
		pane.getChildren().add(imageView3);
		
		// Add refresh button
		Button btRefresh = new Button("Refresh");
		btRefresh.setOnAction(e -> getRandomCards(pane));
		pane.getChildren().add(btRefresh);
		
	}
}