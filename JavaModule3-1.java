// GeometricObject.java
public abstract class GeometricObject {
    // Private fields for color, filled status, and creation date
    private String color = "white";
    private boolean filled;
    private java.util.Date dateCreated;

    // Default constructor initializing the creation date
    protected GeometricObject() {
        dateCreated = new java.util.Date();
    }

    // Constructor with parameters for color and filled status
    protected GeometricObject(String color, boolean filled) {
        dateCreated = new java.util.Date();
        this.color = color;
        this.filled = filled;
    }

    // Getter for color
    public String getColor() {
        return color;
    }

    // Setter for color
    public void setColor(String color) {
        this.color = color;
    }

    // Getter for filled status
    public boolean isFilled() {
        return filled;
    }

    // Setter for filled status
    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    // Getter for creation date
    public java.util.Date getDateCreated() {
        return dateCreated;
    }

    // Overridden toString method to provide string representation
    @Override
    public String toString() {
        return "created on " + dateCreated + "\ncolor: " + color + " and filled: " + filled;
    }

    // Abstract method to get area (to be implemented by subclasses)
    public abstract double getArea();

    // Abstract method to get perimeter (to be implemented by subclasses)
    public abstract double getPerimeter();
}

// Circle.java
public class Circle extends GeometricObject implements Comparable<Circle> {
    // Private field for radius
    private double radius;

    // Default constructor
    public Circle() {
    }

    // Constructor with radius parameter
    public Circle(double radius) {
        this.radius = radius;
    }

    // Constructor with radius, color, and filled status parameters
    public Circle(double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }

    // Getter for radius
    public double getRadius() {
        return radius;
    }

    // Setter for radius
    public void setRadius(double radius) {
        this.radius = radius;
    }

    // Overridden method to calculate area
    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    // Overridden method to calculate perimeter
    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    // Implementation of compareTo method for comparing circles by radius
    @Override
    public int compareTo(Circle o) {
        if (this.radius > o.radius) {
            return 1;
        } else if (this.radius < o.radius) {
            return -1;
        } else {
            return 0;
        }
    }

    // Overridden equals method to compare circles by radius
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Circle) {
            Circle other = (Circle) obj;
            return this.radius == other.radius;
        }
        return false;
    }

    // Overridden toString method to provide string representation
    @Override
    public String toString() {
        return "Circle with radius " + radius;
    }
}
