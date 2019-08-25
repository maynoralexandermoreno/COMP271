Textbook pg 445, #11.1 and #11.3

11.1 (The Triangle class) Design a class named Triangle that extends
GeometricObject. The class contains:

■ Three double data fields named side1, side2, and side3 with default values 1.0 to denote three sides of the triangle.

■ A no-arg constructor that creates a default triangle.

■ A constructor that creates a triangle with the specified side1, side2, and side3.

■ The accessor methods for all three data fields.

■ A method named getArea() that returns the area of this triangle.

■ A method named getPerimeter() that returns the perimeter of this triangle.

■ A method named toString() that returns a string description for the triangle.

For the formula to compute the area of a triangle, see Programming Exercise 2.19.

The toString() method is implemented as follows: return "Triangle: side1 = " + side1 + " side2 = " + side2 + " side3 = " + side3;

Draw the UML diagrams for the classes Triangle and GeometricObject and
implement the classes. Write a test program that prompts the user to enter three
sides of the triangle, a color, and a Boolean value to indicate whether the triangle
is filled. The program should create a Triangle object with these sides and set
the color and filled properties using the input. The program should display
the area, perimeter, color, and true or false to indicate whether it is filled or not.

11.3 (Subclasses of Account) 
In Programming Exercise 9.7, the Account class was defined to model a bank account. An account has the properties account number, balance, annual interest rate, and date created, and methods to deposit and with-draw funds. Create two subclasses for checking and saving accounts. A checking

account has an overdraft limit, but a savings account cannot be overdrawn.
Draw the UML diagram for the classes and then implement them. Write
a test program that creates objects of Account, SavingsAccount, and
CheckingAccount and invokes their toString() methods.

Please submit 

1. UML with java codes and output

2. source code files (.java) 
