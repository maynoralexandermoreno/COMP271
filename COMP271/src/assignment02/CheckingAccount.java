/*
 * Extends the original Account class, so that the CheckingAccount can have the properties of 
 * the the Account class. Overrides the withdraw method to be able to have a different execution.
 */
package assignment02;

public class CheckingAccount extends Account{
	private static final int overdraft = -45;
	
	public CheckingAccount(){
		super();
	}
	public CheckingAccount(int i, double b){
		super(i,b);
	}
	@Override
	public void withdraw(double withdrawl){
		double x = super.getBalance();
		if(x-withdrawl >= overdraft){
			super.setBalance(x - withdrawl); 
		}
		else{
			System.out.println("Transaction cannot be processed, as it will exceed the overdraft limit");
		}
	}
}
