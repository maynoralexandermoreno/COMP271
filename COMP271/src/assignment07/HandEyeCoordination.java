/*
 * Exercise in event handling with non-button objects
 * When the circle is clicked, a new pane with a different circle is loaded onto the scene.
 * Uses a static variable to keep count of time and clicks.
 * Every time the circle is clicked, the pane is cleared and new circle into the pane.
 * As well, every time the circle is clicked, count increases by 1.
 * If count is less than 20, it will show a new circle
 * Once 20, It will show the time spent.
 * 
 */
package assignment07;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.FontPosture;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import java.util.*;

public class HandEyeCoordination extends Application {
	private static int count = 0;
	private static long startT = System.currentTimeMillis();
	public int count(){
		return count;
	}
	public double ranDouble(){
		double d;
		Random r = new Random();
		do {
			d = r.nextDouble() * 200;
		} while (d <= 10);
		return d;
	}
	public double rgb(){
		double f;
		Random r = new Random();
		f = r.nextDouble();
		return f;
	}

	// Application contains start method, Application.Launch uses this to start the GUI
	@Override
	public void start(Stage primaryStage){	
		
		Pane pane = new Pane();
		getNewCircle(pane);
		Scene scene = new Scene(pane, 200, 200);
		primaryStage.setTitle("HandEyeCoordination");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	public void getNewCircle(Pane pane){
		pane.getChildren().clear();
		
		if (count() < 20){
			Circle circle = new Circle();
			circle.setCenterX(ranDouble());
			circle.setCenterY(ranDouble());
			circle.setRadius(10);
			circle.setStroke(Color.color(rgb(), rgb(), rgb()));
			circle.setFill(Color.color(rgb(), rgb(), rgb()));
			circle.setOnMouseClicked(e -> getNewCircle(pane));
			pane.getChildren().add(circle);
			count = count + 1;
//			System.out.println(count); //	This would count the circle clicks after each one
		}
		else{
			String s = "Time spent is " + ((System.currentTimeMillis() - startT) ) + " miliseconds.";
			pane.getChildren().clear();
			pane.setPadding(new Insets(5,5,5,5));
			Text time = new Text(20,20,s);
			time.setFont(Font.font("Times New Roman", FontWeight.NORMAL, FontPosture.REGULAR, 12));
			pane.getChildren().add(time);
		}
	}
	public static void main(String[] args) {
		Application.launch(args);	
	}
}
