import java.util.Scanner;

public class IdenticalArrays {

    // Method to check if two 2D arrays are identical
    public static boolean equals(int[][] m1, int[][] m2) {
        // Check if the number of rows is different
        if (m1.length != m2.length) {
            return false;
        }
        // Iterate through each row
        for (int i = 0; i < m1.length; i++) {
            // Check if the number of columns in the current row is different
            if (m1[i].length != m2[i].length) {
                return false;
            }
            // Iterate through each column in the current row
            for (int j = 0; j < m1[i].length; j++) {
                // Check if the elements are different
                if (m1[i][j] != m2[i][j]) {
                    return false;
                }
            }
        }
        // If all elements are the same, return true
        return true;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Prompt user to enter the first 2D array
        System.out.print("Enter list1: ");
        int[][] list1 = readArray(input, 3, 3); // Adjust the size as needed

        // Prompt user to enter the second 2D array
        System.out.print("Enter list2: ");
        int[][] list2 = readArray(input, 3, 3); // Adjust the size as needed

        // Check if the two arrays are identical and print the result
        if (equals(list1, list2)) {
            System.out.println("The two arrays are identical");
        } else {
            System.out.println("The two arrays are not identical");
        }
    }

    // Method to read a 2D array from user input
    public static int[][] readArray(Scanner input, int rows, int cols) {
        int[][] array = new int[rows][cols];
        // Iterate through each row
        for (int i = 0; i < rows; i++) {
            // Iterate through each column in the current row
            for (int j = 0; j < cols; j++) {
                // Read the element from user input
                array[i][j] = input.nextInt();
            }
        }
        return array;
    }
}
