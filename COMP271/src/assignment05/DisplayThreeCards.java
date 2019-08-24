/*
 * Requires the images of the card faces in the .zip file provided by instructor
 */
package assignment05;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.util.*;

public class DisplayThreeCards extends Application {
	@Override
	public void start(Stage primaryStage){
//	Creates an ArrayList with Integer objects, numbers 1-53
		ArrayList<Integer> list = new ArrayList<>();
		for(int i = 1; i < 53; i++){
			list.add(i);
		}
		
// 	Shuffles the data and then creates a string with the random filename of the images (the images are labeled 1-53)
		java.util.Collections.shuffle(list);
		String imageString0 = "file:card/" + list.get(0) + ".png";
		String imageString1 = "file:card/" + list.get(1) + ".png";
		String imageString2 = "file:card/" + list.get(2) + ".png";
		
// 	Creates a new Pane
		Pane pane = new HBox(10);
		pane.setPadding(new Insets(5,5,5,5));

//	Add all 3 images into the pane
		Image image0 = new Image(imageString0);
		ImageView imageView0 = new ImageView(image0);
		pane.getChildren().add(imageView0);
		
		Image image1 = new Image(imageString1);
		ImageView imageView1 = new ImageView(image1);
		pane.getChildren().add(imageView1);
		
		Image image2 = new Image(imageString2);
		ImageView imageView2 = new ImageView(image2);
		pane.getChildren().add(imageView2);
	
//	Set the Scene with the Pane in it, then set the Stage with the Scene in it.
		Scene scene = new Scene(pane);
		primaryStage.setTitle("ShowImage");
		primaryStage.setScene(scene);
		primaryStage.show();
		}
	
	public static void main(String[] args) {
	
		Application.launch(args);
		

	}

}
