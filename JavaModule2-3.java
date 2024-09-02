// Custom exception class for binary format errors
class BinaryFormatException extends Exception {
    public BinaryFormatException(String message) {
        super(message);
    }
}

public class BinaryConverter {

    // Method to convert a binary string to a decimal integer
    public static int bin2dec(String binaryString) throws BinaryFormatException {
        // Check if the string is a valid binary string
        for (char ch : binaryString.toCharArray()) {
            if (ch != '0' && ch != '1') {
                // Throw BinaryFormatException if an invalid character is found
                throw new BinaryFormatException("Invalid binary string: " + binaryString);
            }
        }

        // Convert the binary string to a decimal integer
        int decimalValue = 0;
        for (int i = 0; i < binaryString.length(); i++) {
            char bit = binaryString.charAt(binaryString.length() - 1 - i);
            if (bit == '1') {
                decimalValue += Math.pow(2, i);
            }
        }

        return decimalValue;
    }

    public static void main(String[] args) {
        try {
            // Test the bin2dec method with a valid binary string
            String binaryString = "1101";
            int decimalValue = bin2dec(binaryString);
            System.out.println("The decimal value of " + binaryString + " is " + decimalValue);

            // Test the bin2dec method with an invalid binary string
            String invalidBinaryString = "11012";
            decimalValue = bin2dec(invalidBinaryString);
            System.out.println("The decimal value of " + invalidBinaryString + " is " + decimalValue);
        } catch (BinaryFormatException e) {
            // Handle the BinaryFormatException
            System.err.println(e.getMessage());
        }
    }
}
