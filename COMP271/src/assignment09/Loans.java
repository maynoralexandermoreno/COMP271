/*
 * Creation of a GUI for a previous program, Loans
 * Combines event handling, clearing objects in Pane and displaying new ones, try-catch, and inner classes
 */
package assignment09;

import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.text.DecimalFormat;


public class Loans extends Application {
	Button showTable;
	TextField tfLoan = new TextField();
	TextField tfYears = new TextField();
	TextArea tableArea = new TextArea("");
	
	@Override
	public void start(Stage primaryStage){
		//mainPane holds both the displayed table and the top entry fields
		Pane mainPane = new VBox();
		
		//topEntry holds the textfields and buttons for text input and button setting
		FlowPane topEntry = new FlowPane();
		topEntry.setHgap(5);
		topEntry.getChildren().add(new Label("Loan Amount"));
		tfLoan.setMaxWidth(100);
		topEntry.getChildren().add(tfLoan);
		topEntry.getChildren().add(new Label(" Number of Years"));
		tfYears.setMaxWidth(45);
		topEntry.getChildren().add(tfYears);
		showTable = new Button("Show Table");
		showTable.setOnAction(e -> tableArea.setText(Calculated()));
		
		ScrollPane tableScroll = new ScrollPane(tableArea);
		topEntry.getChildren().add(showTable);
		mainPane.getChildren().add(topEntry);
		mainPane.getChildren().add(tableScroll);

		
		//basic display scene stuffs
		Scene scene = new Scene(mainPane, 450, 200);
	    primaryStage.setTitle("16_13"); // Set the stage title
	    primaryStage.setResizable(false);
	    primaryStage.setScene(scene); // Place the scene in the stage
	    primaryStage.show(); // Display the stage	
	}
	
	public String Calculated(){
		double numberOfYears, loanAmount;
		DecimalFormat df = new DecimalFormat("#######0.00");
		try{
			loanAmount = Double.parseDouble(tfLoan.getText());
			System.out.println(loanAmount);  /**print statements*/
			numberOfYears = Double.parseDouble(tfYears.getText());					
			System.out.println(numberOfYears); /**print statements*/
			
			loan l = new loan(loanAmount, numberOfYears);
			String table = "";
			table = table + "Interest Rate" + "\t\t\t" + "Monthly Payment" + "\t\t\t" + "Total Payment" + "\t\t\t\n";
			
			for(double interest = 5; interest <= 8; interest = interest + 0.125){
				l.setAnnualInterestRate(interest);
				table = table + df.format(interest) + "\t\t\t\t\t" + df.format(l.getMonthlyPayment())  + "\t\t\t\t\t" + df.format(l.getTotalPayment()) + "\t\t\t\t\t\n";
				}
			return table;			
		}
		catch (NumberFormatException nf){
			String nfException = "One or more fields contained a non-numerical value. \nAcceptable values are 0-9 and decimals. \nOnce corrected, select Show Table to display.";
			return nfException;		
			}
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
	
	//loan class to create a loan object to handle all the mathematical operations
	class loan{
		
		/** fields for each aspect of the loan */
		private double annualInterestRate;
		private double numberOfYears;
		private double loanAmount;
		private java.util.Date loanDate;
		
		//constructors
		/** Default constructor */
		public loan(double LoanAmount, double years) {
			this.annualInterestRate = 5;
			this.numberOfYears = years;
			this.loanAmount = LoanAmount;
			loanDate = new java.util.Date();
		}
		
		/** Construct a loan with specified annual interest rate, number of years and loan amount*/
		public loan(double annualInterestRate, double numberOfYears, double loanAmount) {
			this.annualInterestRate = annualInterestRate;
			this.numberOfYears = numberOfYears;
			this.loanAmount = loanAmount;
			loanDate = new java.util.Date();
		}
		
		//methods
		/** Find monthly payment */
		public double getMonthlyPayment() {
			double monthlyInterestRate = this.annualInterestRate / 1200;
			double monthlyPayment = loanAmount * monthlyInterestRate / (1 -
					(Math.pow(1 / (1 + monthlyInterestRate), numberOfYears * 12)));
			return monthlyPayment;    
		}
		
		/** Find total payment */
		public double getTotalPayment() {
			double totalPayment = getMonthlyPayment() * numberOfYears * 12;
			return totalPayment;    
		}
		
		//getters & setters
		/** Return annualInterestRate */
		public double getAnnualInterestRate() {
			return annualInterestRate;
		}

		/** Set a new annualInterestRate */
		public void setAnnualInterestRate(double annualInterestRate) {
			this.annualInterestRate = annualInterestRate;
		}

		/** Return numberOfYears */
		public double getNumberOfYears() {
			return numberOfYears;
		}

		/** Set a new numberOfYears */
		public void setNumberOfYears(int numberOfYears) {
			this.numberOfYears = numberOfYears;
		}

		/** Return loanAmount */
		public double getLoanAmount() {
			return loanAmount;
		}

		/** Set a newloanAmount */
		public void setLoanAmount(double loanAmount) {
			this.loanAmount = loanAmount;
		}

		/** Return loan date */
		public java.util.Date getLoanDate() {
			return loanDate;
		}
	}
}
