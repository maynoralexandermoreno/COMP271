/*
 * Tests the Circle's methods.
 * Other methods were tested previously; this is a test of the implements aspect.
 */
package assignment03;

public class TestCircle {
	public static void main(String [] args){

		Circle a = new Circle(1.0);
		Circle b = new Circle(2.0);
		Circle c = new Circle(1.0);
	
		System.out.println("Does circle a equal circle b?\t" + a.equals(b));
		System.out.println("Does circle a equal circle c?\t" + a.equals(c));
		System.out.println("Does circle b equal circle c?\t" + b.equals(c));

	}
}
