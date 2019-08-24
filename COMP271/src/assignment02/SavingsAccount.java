/*
 * Extends the original Account class, so that the CheckingAccount can have the properties of 
 * the the Account class. Overrides the withdraw method to be able to have a different execution.
 */
package assignment02;

public class SavingsAccount extends Account {
	public SavingsAccount(){
		super();
	}
	public SavingsAccount(int i, double b){
		super(i,b);
	}
	@Override
	public void withdraw(double withdrawl){
		double x = super.getBalance();
		if(x-withdrawl < 0){
			System.out.println("Your savings account cannot be overdrawn.");
		}
		else{
			super.setBalance(x - withdrawl );; 
		}
	}
}

