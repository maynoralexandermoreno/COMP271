/*
 * Extends GeometricObject, an abstract class, so it MUST @Override toString(), getArea(), and getPerimeter().
 * Implements Comparable<Circle>, so it must @Override the method defined in Comparable using a Circle object.
 */
package assignment03;

public class Circle extends GeometricObject implements Comparable<Circle>{

	private double radius;
	
// Constructors
	public Circle() {
		super();
		this.radius = 1.0;
	}
	public Circle(double radius){
		super();
		this.radius = radius;
	}
	public Circle(double radius, String color, boolean filled){
		super();
		super.setColor(color);
		super.setFilled(filled);
		this.radius = radius;
	}

// Getters and Setters
	public double getRadius(){
		return radius;
	}
	public void setRadius(double radius){
		this.radius = radius;
	}
	@Override
	public double getArea(){
		return radius * radius* Math.PI;
	}
	public double getDiameter(){
		return 2 * radius;
	}
	@Override
	public double getPerimeter(){
		return 2* radius * Math.PI;
	}

// Prints info on circle
	public void printCircle(){
		System.out.println("The circle created " + super.getDateCreated() + " and the radius is " + radius);
	}

// toString method overridden
	@Override
	public String toString(){
		return "temp string";
	}

	public boolean equals(Circle c){
		if (this.compareTo(c) == 0){
			return true;
		}
		else{
			return false;
		}
	}

// compareTo implemented
	@Override
	public int compareTo(Circle o){
		if (this.getRadius() > o.getRadius() || this.getRadius() < o.getRadius()){
			return -1;
		}
		else{
			return 0;
		}
	}
}
