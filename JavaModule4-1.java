import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

public class GroupingSymbolsChecker {

    // Main method to run the program
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java GroupingSymbolsChecker <source-file>");
            return;
        }

        String fileName = args[0];
        GroupingSymbolsChecker checker = new GroupingSymbolsChecker();
        boolean isValid = checker.checkFile(fileName);

        if (isValid) {
            System.out.println("The file has correct pairs of grouping symbols.");
        } else {
            System.out.println("The file has incorrect pairs of grouping symbols.");
        }
    }

    // Method to check the file for correct grouping symbols
    public boolean checkFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            Stack<Character> stack = new Stack<>();
            String line;
            while ((line = reader.readLine()) != null) {
                for (char ch : line.toCharArray()) {
                    if (ch == '(' || ch == '{' || ch == '[') {
                        stack.push(ch);
                    } else if (ch == ')' || ch == '}' || ch == ']') {
                        if (stack.isEmpty() || !isMatchingPair(stack.pop(), ch)) {
                            return false;
                        }
                    }
                }
            }
            return stack.isEmpty();
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return false;
        }
    }

    // Method to check if the characters are matching pairs
    private boolean isMatchingPair(char open, char close) {
        return (open == '(' && close == ')') ||
               (open == '{' && close == '}') ||
               (open == '[' && close == ']');
    }
}
