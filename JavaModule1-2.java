import java.util.Scanner;

public class PalindromeInteger {
    // Return the reversal of an integer
    public static int reverse(int number) {
        int reversed = 0; // Initialize reversed number to 0
        while (number != 0) { // Loop until the number becomes 0
            int digit = number % 10; // Extract the last digit of the number
            reversed = reversed * 10 + digit; // Append the digit to the reversed number
            number /= 10; // Remove the last digit from the number
        }
        return reversed; // Return the reversed number
    }

    // Return true if number is a palindrome
    public static boolean isPalindrome(int number) {
        return number == reverse(number); // Check if the number is equal to its reverse
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); // Create a Scanner object for input
        System.out.print("Enter an integer: "); // Prompt the user to enter an integer
        int number = input.nextInt(); // Read the integer from the user
        
        // Check if the number is a palindrome and display the result
        if (isPalindrome(number)) {
            System.out.println(number + " is a palindrome.");
        } else {
            System.out.println(number + " is not a palindrome.");
        }
        
        input.close(); // Close the Scanner object
    }
}
