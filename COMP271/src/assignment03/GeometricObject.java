/*
 * This GeometricObject class has an abstract method for toString(), getArea(), getPerimeter().
 * Assignment 2 has toString defined within GeometricObject and does not have abstract methods getArea() and getPerimeter();
 * The other methods remain the same.
 */
package assignment03;

abstract class GeometricObject {
	private String color = "white";
	private boolean filled = false;
	private java.util.Date dateCreated;
	
	protected GeometricObject() {
		dateCreated = new java.util.Date();
	}
	
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public boolean isFilled() {
		return filled;
	}
	
	public void setFilled(boolean filled) {
		this.filled = filled;
	}
	
	public java.util.Date getDateCreated() {
	return dateCreated;
	}
	
	public abstract String toString();
	public abstract double getArea();
	public abstract double getPerimeter();
}