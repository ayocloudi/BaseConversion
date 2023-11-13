import java.util.Scanner;

public class BaseConversion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Prompt the user for the base of the given number (base#1)
        System.out.print("Enter the base of the number you're converting from (base#1): ");
        int base1 = scanner.nextInt();
        
        // Prompt the user for the base to which the number should be converted (base#2)
        System.out.print("Enter the base you're converting to (base#2): ");
        int base2 = scanner.nextInt();
        
        // Prompt the user for the number in base#1 as a string
        System.out.print("Enter the number in base#1 to convert: ");
        scanner.nextLine();  // Consume the newline left by nextInt()
        String numberInBase1 = scanner.nextLine();
        
        // Convert from base#1 to base 10
        int numberInBase10 = 0;
        // Go through each character of the string
        for (int i = 0; i < numberInBase1.length(); i++) {
            char digitChar = numberInBase1.charAt(i);
            int digitValue;
            // If the character is a digit (0-9), subtract '0' to get the integer value
            if (Character.isDigit(digitChar)) {
                digitValue = digitChar - '0';
            } else {
                // If the character is a letter (a-z), subtract 'a' and add 10 to get the integer value
                digitValue = 10 + digitChar - 'a';
            }
            // Calculate the value of the digit in the current position and add to total
            numberInBase10 += digitValue * Math.pow(base1, numberInBase1.length() - 1 - i);
        }

        // Initialize the result string for the number in base#2
        String numberInBase2 = "";
        // Special case for zero as it would not enter the loop
        if (numberInBase10 == 0) {
            numberInBase2 = "0";
        } else {
            // Loop to convert the number to the new base
            while (numberInBase10 > 0) {
                // Find the remainder when the number is divided by the new base
                int remainder = numberInBase10 % base2;
                // Determine the character to represent the digit in the new base
                char digit = remainder < 10 ? (char) ('0' + remainder) : (char) ('a' + remainder - 10);
                // Prepend the digit to the result string
                numberInBase2 = digit + numberInBase2;
                // Divide the number by the new base
                numberInBase10 /= base2;
            }
        }

        // Print the result
        System.out.println("Converted number in base#" + base2 + ": " + numberInBase2);
    }
}