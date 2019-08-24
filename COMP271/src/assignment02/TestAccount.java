/*
 * Tests the creation of a CheckingAccount and SavingsAccount object, and implements their methods.
 */
package assignment02;

public class TestAccount extends Account {

	public static void main(String[] args) {
		CheckingAccount c1 = new CheckingAccount(1, 1000);
		SavingsAccount s1 = new SavingsAccount(2, 2000);
		int x = c1.getId();
		int y = s1.getId();
		System.out.println(x);
		System.out.println(y);
		c1.deposit(500);
		System.out.println(c1.getBalance());
		s1.deposit(1000);
		System.out.println(s1.getBalance());
		c1.withdraw(1544);
		System.out.println(c1.getBalance());
		s1.withdraw(3001);
		c1.withdraw(2);
		System.out.println(c1.toString() + "\n" + s1.toString());
		
	}
	
	
}
