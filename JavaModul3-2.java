import java.math.BigInteger;

public class Rational {
    private BigInteger numerator;
    private BigInteger denominator;

    // Constructor to initialize the Rational object with numerator and denominator
    public Rational(BigInteger numerator, BigInteger denominator) {
        BigInteger gcd = numerator.gcd(denominator); // Find the greatest common divisor
        this.numerator = numerator.divide(gcd); // Simplify the numerator
        this.denominator = denominator.divide(gcd); // Simplify the denominator
    }

    // Method to add two Rational numbers
    public Rational add(Rational secondRational) {
        BigInteger n = numerator.multiply(secondRational.denominator)
                .add(denominator.multiply(secondRational.numerator)); // Calculate the new numerator
        BigInteger d = denominator.multiply(secondRational.denominator); // Calculate the new denominator
        return new Rational(n, d); // Return the result as a new Rational object
    }

    // Method to subtract two Rational numbers
    public Rational subtract(Rational secondRational) {
        BigInteger n = numerator.multiply(secondRational.denominator)
                .subtract(denominator.multiply(secondRational.numerator)); // Calculate the new numerator
        BigInteger d = denominator.multiply(secondRational.denominator); // Calculate the new denominator
        return new Rational(n, d); // Return the result as a new Rational object
    }

    // Method to multiply two Rational numbers
    public Rational multiply(Rational secondRational) {
        BigInteger n = numerator.multiply(secondRational.numerator); // Calculate the new numerator
        BigInteger d = denominator.multiply(secondRational.denominator); // Calculate the new denominator
        return new Rational(n, d); // Return the result as a new Rational object
    }

    // Method to divide two Rational numbers
    public Rational divide(Rational secondRational) {
        BigInteger n = numerator.multiply(secondRational.denominator); // Calculate the new numerator
        BigInteger d = denominator.multiply(secondRational.numerator); // Calculate the new denominator
        return new Rational(n, d); // Return the result as a new Rational object
    }

    // Override the toString method to display the Rational number as a string
    @Override
    public String toString() {
        if (denominator.equals(BigInteger.ONE)) {
            return numerator.toString(); // If the denominator is 1, return only the numerator
        } else {
            return numerator + "/" + denominator; // Otherwise, return the fraction
        }
    }

    // Main method to test the Rational class
    public static void main(String[] args) {
        java.util.Scanner input = new java.util.Scanner(System.in);

        // Prompt the user to enter the first rational number
        System.out.print("Enter the first rational number: ");
        BigInteger n1 = input.nextBigInteger();
        BigInteger d1 = input.nextBigInteger();
        Rational r1 = new Rational(n1, d1);

        // Prompt the user to enter the second rational number
        System.out.print("Enter the second rational number: ");
        BigInteger n2 = input.nextBigInteger();
        BigInteger d2 = input.nextBigInteger();
        Rational r2 = new Rational(n2, d2);

        // Display the results of arithmetic operations
        System.out.println(r1 + " + " + r2 + " = " + r1.add(r2));
        System.out.println(r1 + " - " + r2 + " = " + r1.subtract(r2));
        System.out.println(r1 + " * " + r2 + " = " + r1.multiply(r2));
        System.out.println(r1 + " / " + r2 + " = " + r1.divide(r2));
        System.out.println(r2 + " is " + r2.numerator.doubleValue() / r2.denominator.doubleValue());
    }
}
