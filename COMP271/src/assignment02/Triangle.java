/*
 * Extends GeometricObject so that Triangle objects have access to the methods and data fields defined
 * in GeometricObject. Overrides the toString method so as to print a different message than that defined
 * in GeometricObject.
 */
package assignment02;

public class Triangle extends GeometricObject {
	//Three double data fields named...with default values 1.0...
	private double side1 = 1.0;
	private double side2 = 1.0;
	private double side3 = 1.0;
	//No-arg constructor
	public Triangle(){
		super();
	}
	//Constructor with specified sides 1, 2, 3
	public Triangle(double a, double b, double c) {
		super();
		side1 = a; side2 = b; side3 = c;	
	}
	//getter methods for all three data fields
	public double getSide1(){
		return side1;
	}
	public double getSide2(){
		return side2;
	}
	public double getSide3(){
		return side3;
	}
	//method getArea()
	public double getArea() {	
		double p = this.getPerimeter() / 2.0;
		double d = Math.sqrt(p*(p-side1)*(p-side2)*(p-side3));
		return d;
	}
	//method getPerimeter()
	public double getPerimeter() {
		return (this.side1 + this.side2 + this.side3);
	}
	@Override
	public String toString(){
		return "Triangle: side 1 = " + side1 + " side2 = " + side2 + " side3 = " + side3;
	}
}