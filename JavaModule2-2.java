// Triangle.java: The Triangle class that extends GeometricObject
public class Triangle extends GeometricObject {
  private double side1;
  private double side2;
  private double side3;

  /** Default constructor */
  public Triangle() {
    this(1.0, 1.0, 1.0);
  }

  /** Constructor with specified sides */
  public Triangle(double side1, double side2, double side3) {
    this.side1 = side1;
    this.side2 = side2;
    this.side3 = side3;
  }

  /** Getter for side1 */
  public double getSide1() {
    return side1;
  }

  /** Setter for side1 */
  public void setSide1(double side1) {
    this.side1 = side1;
  }

  /** Getter for side2 */
  public double getSide2() {
    return side2;
  }

  /** Setter for side2 */
  public void setSide2(double side2) {
    this.side2 = side2;
  }

  /** Getter for side3 */
  public double getSide3() {
    return side3;
  }

  /** Setter for side3 */
  public void setSide3(double side3) {
    this.side3 = side3;
  }

  /** Calculate the area of the triangle */
  @Override
  public double getArea() {
    double s = (side1 + side2 + side3) / 2;
    return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
  }

  /** Calculate the perimeter of the triangle */
  @Override
  public double getPerimeter() {
    return side1 + side2 + side3;
  }

  /** Return a string description of the triangle */
  @Override
  public String toString() {
    return "Triangle: side1 = " + side1 + " side2 = " + side2 + " side3 = " + side3;
  }
}

// TestTriangle.java: A test program for the Triangle class
import java.util.Scanner;

public class TestTriangle {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    // Prompt the user to enter the sides of the triangle
    System.out.print("Enter side1: ");
    double side1 = input.nextDouble();
    System.out.print("Enter side2: ");
    double side2 = input.nextDouble();
    System.out.print("Enter side3: ");
    double side3 = input.nextDouble();

    // Prompt the user to enter the color
    System.out.print("Enter the color: ");
    String color = input.next();

    // Prompt the user to enter whether the triangle is filled
    System.out.print("Is the triangle filled (true/false)? ");
    boolean filled = input.nextBoolean();

    // Create a Triangle object with the specified sides
    Triangle triangle = new Triangle(side1, side2, side3);
    triangle.setColor(color);
    triangle.setFilled(filled);

    // Display the area, perimeter, color, and filled status
    System.out.println("Area: " + triangle.getArea());
    System.out.println("Perimeter: " + triangle.getPerimeter());
    System.out.println("Color: " + triangle.getColor());
    System.out.println("Filled: " + triangle.isFilled());
  }
}
