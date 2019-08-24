/*
 * Tests the creation of a triangle using user inputs.
 */
package assignment02;

import java.util.Scanner;

public class TestTriangle {

	public static void main(String[]args){
		Scanner in = new Scanner(System.in);
		System.out.println("Please enter 3 numbers: ");

		double x = in.nextDouble();
		double y = in.nextDouble();
		double z = in.nextDouble();
		//create new triangle object with sides of x, y, z
		Triangle t = new Triangle(x,y,z);
		//set the triangle color color
		System.out.println("Please enter a color");
		String s = in.next();
		t.setColor(s);
		//Set the boolean value of filled to true
		System.out.println("Please enter true if the triangle is filled, and false if it is not (boolean are case sensitive).");
		Boolean f = in.nextBoolean();
		t.setFilled(f);
		
		System.out.println(t.getArea());
		System.out.println(t.getPerimeter());
		System.out.println(t.getColor());
		System.out.println(t.isFilled());
		System.out.println(t.toString());
		
		in.close();
	}

}
