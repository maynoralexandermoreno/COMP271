/*
 * 	Exercise in radio buttons and how they affect the GUI
 */
package assignment08;

import  javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class TrafficLights extends Application {
	
	  @Override // Override the start method in Application
	  public void start(Stage primaryStage)  {

		BorderPane bPane = new BorderPane();
		
		Pane trafficLight = new Pane();
		trafficLight.setPadding(new Insets (2,2,2,2));
		//	Create all circles (initially circles not filled in)
		Circle cR = new Circle(10);
		cR.setCenterX(100);
		cR.setCenterY(76);
		cR.setStroke(Color.BLACK);
		cR.setFill(null);
		Circle cY = new Circle(10);
		cY.setCenterX(100);
		cY.setCenterY(100);
		cY.setStroke(Color.BLACK);
		cY.setFill(null);
		Circle cG = new Circle(10);
		cG.setCenterX(100);
		cG.setCenterY(124);
		cG.setStroke(Color.BLACK);
		cG.setFill(null);
		Rectangle r = new Rectangle(86,63,28,74);
		r.setStroke(Color.BLACK);
		r.setFill(null);
		trafficLight.getChildren().addAll(cR,cY,cG,r);
//		trafficLight.setTop(cG);
//		trafficLight.setCenter(cY);
//		trafficLight.setBottom(cG);
		
	    bPane.setCenter(trafficLight);
	    
	    //creates an HBox for the radio buttons to put at the bottom
	    HBox paneForRadioButtons = new HBox(20);
	    paneForRadioButtons.setPadding(new Insets(5, 5, 5, 5)); 
	    paneForRadioButtons.setStyle("-fx-border-color: white");
	    paneForRadioButtons.setStyle
	      ("-fx-border-width: 2px; -fx-border-color: white");
	    
	    RadioButton rbRed = new RadioButton("Red");
	    RadioButton rbYellow = new RadioButton("Yellow");
	    RadioButton rbGreen = new RadioButton("Green");
	    paneForRadioButtons.getChildren().addAll(rbRed, rbYellow, rbGreen);
	    bPane.setBottom(paneForRadioButtons);
	    
	    // ToggleGroup allows for the same event to come from clicking any object in the group
	    ToggleGroup group = new ToggleGroup();
	    rbRed.setToggleGroup(group);
	    rbYellow.setToggleGroup(group);
	    rbGreen.setToggleGroup(group);
	    
	    //	If any radio button is clicked, each button will see if they were selected and change the fill accordingly
	    rbGreen.setOnAction(e -> {
	      if (rbGreen.isSelected()) {
	        cG.setFill(Color.GREEN);
	        cY.setFill(null);
	        cR.setFill(null);
	        
	      }
	    });
	    
	    rbYellow.setOnAction(e -> {
	      if (rbYellow.isSelected()) {
	    	  cG.setFill(null);
	    	  cY.setFill(Color.YELLOW);
	    	  cR.setFill(null);
	      }
	    });
	    
	    rbRed.setOnAction(e -> {
	      if (rbRed.isSelected()) {
	    	  cG.setFill(null);
	    	  cY.setFill(null);
	    	  cR.setFill(Color.RED);
	      }
	    });
	    
	    // Set the pane in the scene and the scene in the state
	    Scene scene = new Scene(bPane, 200, 200);
	    primaryStage.setTitle("HW 16.3"); // Set the stage title
	    primaryStage.setResizable(false);
	    primaryStage.setScene(scene); // Place the scene in the stage
	    primaryStage.show(); // Display the stage
	    

	  }
	  public static void main(String[] args) {
	    launch(args);
	  }
	}