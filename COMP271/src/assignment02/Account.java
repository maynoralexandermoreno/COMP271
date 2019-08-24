/*
 * Account class was provided from the textbook.
 */
package assignment02;

public class Account {
	private int id;
	private double balance, annualInterestRate;
	private java.util.Date dateCreated;
	public Account(){
		id = 0;
		balance = 0;
		annualInterestRate = 0;
		dateCreated = new java.util.Date();
	}
	public Account(int id, double initialBalance){
		this.id = id;
		balance = initialBalance;
		annualInterestRate = 0;
		dateCreated = new java.util.Date();
	}	
	public double getMonthlyInterestRate(){
		double monthlyInterestRate = annualInterestRate /1200.00;
		return monthlyInterestRate;
	}
	public double getMonthlyInterest(){
		double monthlyInterest = balance * getMonthlyInterestRate();
		return monthlyInterest;
	}
	public void withdraw(double withdrawl){
		this.balance = this.balance - withdrawl ; 
	}
	public void deposit(double deposit) {
		this.balance = this.balance + deposit;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public double getAnnualInterestRate() {
		return annualInterestRate;
	}
	public void setAnnualInterestRate(double annualInterestRate) {
		this.annualInterestRate = annualInterestRate;
	}
	public java.util.Date getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(java.util.Date dateCreated) {
		this.dateCreated = dateCreated;
	}	
}
