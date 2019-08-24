/*
 * GeometricObject was defined in the textbook.
 * However, since the original class was edited and modified throughout 
 */
package assignment02;

public class GeometricObject {
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
	
	public String toString() {
		return "\ncreated on " + dateCreated + "\ncolor: " + color +" and filled: " + filled;
	}
}
