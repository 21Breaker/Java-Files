import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class CountKeywords {

    // Set of Java keywords
    private static final Set<String> keywords = new HashSet<>();

    static {
        String[] keywordArray = {
            "abstract", "assert", "boolean", "break", "byte", "case", "catch", "char", "class", "const",
            "continue", "default", "do", "double", "else", "enum", "extends", "final", "finally", "float",
            "for", "goto", "if", "implements", "import", "instanceof", "int", "interface", "long", "native",
            "new", "package", "private", "protected", "public", "return", "short", "static", "strictfp",
            "super", "switch", "synchronized", "this", "throw", "throws", "transient", "try", "void",
            "volatile", "while"
        };
        for (String keyword : keywordArray) {
            keywords.add(keyword);
        }
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java CountKeywords <source-file>");
            return;
        }

        String fileName = args[0];
        CountKeywords counter = new CountKeywords();
        int keywordCount = counter.countKeywords(fileName);

        System.out.println("The number of keywords in the file is: " + keywordCount);
    }

    // Method to count keywords in the file
    public int countKeywords(String fileName) {
        int count = 0;
        boolean inBlockComment = false;
        boolean inLineComment = false;
        boolean inString = false;

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                for (int i = 0; i < line.length(); i++) {
                    char ch = line.charAt(i);

                    // Check for start of block comment
                    if (ch == '/' && i + 1 < line.length() && line.charAt(i + 1) == '*') {
                        inBlockComment = true;
                        i++;
                    } 
                    // Check for end of block comment
                    else if (ch == '*' && i + 1 < line.length() && line.charAt(i + 1) == '/') {
                        inBlockComment = false;
                        i++;
                    } 
                    // Check for line comment
                    else if (ch == '/' && i + 1 < line.length() && line.charAt(i + 1) == '/') {
                        inLineComment = true;
                        break;
                    } 
                    // Check for string literal
                    else if (ch == '\"') {
                        inString = !inString;
                    }

                    // Count keywords if not in comment or string
                    if (!inBlockComment && !inLineComment && !inString) {
                        String[] words = line.split("\\W+");
                        for (String word : words) {
                            if (keywords.contains(word)) {
                                count++;
                            }
                        }
                    }
                }
                inLineComment = false;
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        return count;
    }
}
