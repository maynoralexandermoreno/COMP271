/*
 * Running the program will state what each value is. 
 */
package assignment01;

import java.util.Scanner;

public class TestMyInteger {
//Testing, Testing, 1 2 3 
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int i = 0;
		System.out.print("Input integer: ");
		i = in.nextInt();
//test the creation of a MyInteger object		
		MyInteger m = new MyInteger(i);
		MyInteger n = new MyInteger(6);
//test the Getter		
		System.out.println(m.getInteger());
		System.out.println(n.getInteger() + "\n");
//test the isEven(), isOdd(), isPrime()
		System.out.println("Is your number (" + m.getInteger() + ") Even? Odd? Prime");
		System.out.println(m.isEven() + " ");
		System.out.println(m.isOdd() + " ");
		System.out.println(m.isPrime() + "\n");
//test the isEven(int), isOdd(int), isPrime(int)
		System.out.println("Is the number 5 Even? Odd? Prime?");
		System.out.println(MyInteger.isEven(5));
		System.out.println(MyInteger.isOdd(5));
		System.out.println(MyInteger.isPrime(5) + "\n");
//test the isEven(MyInteger), isOdd(MyInteger), isPrime(MyInteger)
		System.out.println("Is MyInteger n (" + n.getInteger() + ") Even? Odd? Prime? ");
		System.out.println(MyInteger.isEven(n));
		System.out.println(MyInteger.isOdd(n));
		System.out.println(MyInteger.isPrime(n) + "\n");
//test the equals functions
		System.out.println("Is MyInteger m equal to 5? n?");
		System.out.println(m.equals(5));
		System.out.println(m.equals(n) + "\n");
// test the string and char[] conversions
		char[] c = new char[2]; c[0] = '1'; c[1] = '5';
		String s = "20";
		System.out.println("The ints of the char[] {1,5} and String \"20\" are:");
		int C = MyInteger.parseInt(c);
		int S = MyInteger.parseInt(s);
		System.out.println(C);
		System.out.println(S);
		
		in.close();
	}

}
