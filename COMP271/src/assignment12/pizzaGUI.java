/*
 * Create a GUI for a pizza ordering. Take into account all previous lessons.
 * Keep in mind a person might change their minds on different aspects of food.
 * If incredibly ambitious, one can also create a file with different images for the different combos (I didn't).
 * Note: I wrote this with the idea of making it for Guy Fiery.
 * The idea of that man owning a restaurant amuses me.
 */
package assignment12;
import java.text.DecimalFormat;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.Pane;
import javafx.scene.control.Button;

public class pizzaGUI extends Application {
	TextArea ta = new TextArea("Please select the size and toppings desired.\nThe total will be presented here.");
	BorderPane mainPane = new BorderPane();
	Button btClear = new Button("Clear Order");
	Button btSubmit = new Button("Submit Order");
	int meatCount = 0;
	int vegCount = 0;
	int size = 0;
	double total = 0;
	String meats = "THE MEATS: ";
	String veggies = "THE VEGGIES: ";
	String taString = "";
	DecimalFormat df = new DecimalFormat( "####.00");
	@Override
	public void start(Stage primaryStage){
		ta.setWrapText(true);
		setMainPane(this.mainPane);
		Scene scene = new Scene(this.mainPane, 600, 500);
		primaryStage.setTitle("Pizza Party!");
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
	
	public void setMainPane(BorderPane mainPane){
		mainPane.getChildren().clear();
		this.meatCount = 0;
		this.vegCount = 0;
		this.size = 0;
		this.total = 0;
		this.meats = "Meat Toppings: ";
		this.veggies = "Non-Meat Toppings: ";

		//sets the top as radio buttons for a size of pizza
		VBox spacing = new VBox(20);
		Pane pane1 = new Pane();
		Pane pane2 = new Pane();
		HBox pizzaSelect = new HBox(20);
		ToggleGroup group = new ToggleGroup();
		RadioButton personal = new RadioButton("Personal Pie");
		personal.setContentDisplay(ContentDisplay.LEFT);
		personal.setToggleGroup(group);
		if (personal.isSelected()){
			this.size = 1;
		}
		RadioButton small = new RadioButton("Small Pie");
		small.setContentDisplay(ContentDisplay.LEFT);
		small.setToggleGroup(group);
		RadioButton medium = new RadioButton("Medium Pie");
		medium.setContentDisplay(ContentDisplay.LEFT);
		medium.setToggleGroup(group);
		RadioButton large = new RadioButton("Large Pie");
		large.setContentDisplay(ContentDisplay.LEFT);
		large.setToggleGroup(group);
		RadioButton extralarge = new RadioButton("Extra Large Pie");
		extralarge.setContentDisplay(ContentDisplay.LEFT);
		extralarge.setToggleGroup(group);
		pizzaSelect.getChildren().addAll(personal,small,medium,large,extralarge);
		pizzaSelect.setAlignment(Pos.CENTER);
		spacing.getChildren().addAll(pane1, pizzaSelect, pane2);
		spacing.setStyle("-fx-border-color: black");

		mainPane.setTop(spacing);
		
		//sets the right as checkboxes for vegetable toppings
		HBox spacing3 = new  HBox(10);
		Pane pane5 = new Pane();
		Pane pane6 = new Pane();
		VBox veggieSelect = new VBox(20);
		CheckBox mushrooms = new CheckBox("Mushrooms");
		CheckBox onions = new CheckBox("Onions");
		CheckBox pineapple = new CheckBox("Pineapples");
		CheckBox greenpeppers = new CheckBox("Green Peppers");
		CheckBox olives = new CheckBox("Olives");
		CheckBox extracheese = new CheckBox("Extra Cheese");
		veggieSelect.getChildren().addAll(mushrooms,onions,pineapple,greenpeppers,olives,extracheese);
		spacing3.getChildren().addAll(pane5,veggieSelect,pane6);
		spacing3.setStyle("-fx-border-color: black");
		
		mainPane.setRight(spacing3);
		
		//sets the left as checkboxes for meat toppings
		HBox spacing4 = new  HBox(10);
		Pane pane7 = new Pane();
		Pane pane8 = new Pane();
		VBox meatsSelect = new VBox(20);
		CheckBox pepperoni = new CheckBox("Pepperoni");
		CheckBox sausage = new CheckBox("Sausage");
		CheckBox bacon = new CheckBox("Bacon");
		CheckBox ham = new CheckBox("Ham");
		CheckBox chicken = new CheckBox("Chicken");
		CheckBox beef = new CheckBox("Beef");
		meatsSelect.getChildren().addAll(pepperoni,sausage,bacon,ham,chicken,beef);
		spacing4.getChildren().addAll(pane7,meatsSelect,pane8);
		spacing4.setStyle("-fx-border-color: black");
		
		mainPane.setLeft(spacing4);
		
		

		mainPane.setCenter(ta);
		
		//sets the bottom as buttons for setting and clearing the prices
		VBox spacing2= new VBox(20);
		Pane pane3 = new Pane();
		Pane pane4 = new Pane();
		HBox Buttons = new HBox(15);
		
		btClear.setOnAction(e -> {
		ta.setText("Welcome to FlavorTown Pizzeria!\nPlease select the size and toppings desired!\nThe total will be presented here!");
		setMainPane(this.mainPane);
		});
		
		btSubmit.setOnAction(e -> {
				taString = "Are you ready this EXPLOSION of FLAVOR in your MOUTH?!\n\n";
				taString = taString + "The size of your pizza is ";
				// select the size!
				if (personal.isSelected()){
					this.size = 1;
					taString = taString + "PERSONAL! Looks like a party for 1 over here!\n";
				}
				else if (small.isSelected()){
					this.size = 2;
					taString = taString + "SMALL! Date night anyone?!\n";
				}
				else if (medium.isSelected()){
					this.size = 3;
					taString = taString + "MEDIUM! Time for game night!!\n";
				}
				else if (large.isSelected()){
					this.size = 4;
					taString = taString + "LARGE! Someone's hungry!\n";
				}
				else if (extralarge.isSelected()){
					this.size = 5;
					taString = taString + "EXTRA LARGE! Should last you about a week!\n";
				}
				else {
					this.size = 1;
					taString = taString + "PERSONAL! Looks like someone forgot to select a size! tisk* tisk*\n";
				}
		
				// select the meats!
				if (pepperoni.isSelected()){
					this.meatCount = this.meatCount + 1;
					this.meats = this.meats + " Pepperoni ";
				}
				if (sausage.isSelected()){
					this.meatCount = this.meatCount + 1;
					this.meats = this.meats + " Sausage ";
				}
				if (bacon.isSelected()){
					this.meatCount = this.meatCount + 1;
					this.meats = this.meats + " Bacon ";
				}
				if (ham.isSelected()){
					this.meatCount = this.meatCount + 1;
					this.meats = this.meats + " Ham ";
				}
				if (chicken.isSelected()){
					this.meatCount = this.meatCount + 1;
					this.meats = this.meats + " Chicken ";
				}
				if (beef.isSelected()){
					this.meatCount = this.meatCount + 1;
					this.meats = this.meats + " Beef ";
				}
				// select the veggies!
				if (mushrooms.isSelected()){
					this.vegCount = this.vegCount + 1;
					this.veggies = this.veggies + " Mushrooms ";
				}
				if (onions.isSelected()){
					this.vegCount = this.vegCount + 1;
					this.veggies = this.veggies + " Onions ";
				}
				if (pineapple.isSelected()){
					this.vegCount = this.vegCount + 1;
					this.veggies = this.veggies + " Pineapples ";
				}
				if (greenpeppers.isSelected()){
					this.vegCount = this.vegCount + 1;
					this.veggies = this.veggies + " Green Peppers ";
				}
				if (olives.isSelected()){
					this.vegCount = this.vegCount + 1;
					this.veggies = this.veggies + " Olives ";
				}
				if (extracheese.isSelected()){
					this.vegCount = this.vegCount + 1;
					this.veggies = this.veggies + " Extra Cheese ";
				}
				
				//did you get the meats? the veggies!
				if (this.meatCount > 0 && this.vegCount > 0 ){
					taString = taString + "\n" + this.meats + "\n";
					taString = taString + this.veggies + "\n";
					taString = taString + "Someone is hitting all the major food groups!\n";
				}
				else if ((this.meatCount > 0) && (this.vegCount == 0)){
					taString = taString + "\n" + this.meats + "\n";
					taString = taString + "Looks like someone loves THE MEATS!\n";
				}
				else if ((this.meatCount == 0) && (this.vegCount > 0)){
					taString = taString + "\n" + this.veggies + "\n";
					taString = taString + "Looks like someone is going VEGETARIAN!\n";
				}
				else {
					taString = taString + "\n" + "Cheese Pie? A classic!\n";
				}
				
				//whats the damage?

				pizza ourPizza = new pizza(this.size,this.meatCount,this.vegCount);
				this.total = ourPizza.getTotal();
				taString = taString + "\nThe pizza itself was " + df.format(ourPizza.getPrice()) + ".\n";
				taString = taString + "With " + this.meatCount + " meats and " + this.vegCount + " veggies, plus a 2.50 delivery fee\n";
				taString = taString + "Your total is: " + df.format(this.total + 2.50);
				ta.setText(taString);
				setMainPane(this.mainPane);
		});
		
		Buttons.getChildren().addAll(this.btClear,this.btSubmit);
		Buttons.setAlignment(Pos.CENTER);
		spacing2.getChildren().addAll(pane3, Buttons, pane4);
		spacing2.setStyle("-fx-border-color: black");
		mainPane.setBottom(spacing2);
		
	}

}
