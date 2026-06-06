package rvt;

import java.util.Scanner;
public class connecticut100 {
    

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Put in a loop so the user is repeatedly asked
        while (true) {
            System.out.print("Enter the numerator: ");
            String numInput = scanner.nextLine().trim();

            // Handle empty input to prevent crashes when checking charAt(0)
            if (numInput.isEmpty()) {
                System.out.println("You entered bad data.\nPlease try again.\n");
                continue;
            }

            // 3. Exit the loop when data entered starts with 'q' or 'Q'
            // We use charAt(0) as requested by the exercise instructions
            char firstChar = numInput.charAt(0);
            if (firstChar == 'q' || firstChar == 'Q') {
                break; // 4. Don't ask for divisor if user asked to quit
            }
            
            try {
                // Try to parse the numerator
                int numerator = Integer.parseInt(numInput);

                System.out.print("Enter the divisor: ");
                String divInput = scanner.nextLine().trim();
                
                // Try to parse the divisor
                int divisor = Integer.parseInt(divInput);

                // Handle division by zero manually to match the specific sample output
                if (divisor == 0) {
                    System.out.println("You can't divide " + numerator + " by 0\n");
                } else {
                    int result = numerator / divisor;
                    System.out.println(numerator + " / " + divisor + " is " + result + "\n");
                }

            } catch (NumberFormatException e) {
                // Catch the error if the user types letters instead of numbers (e.g., "glarch")
                System.out.println("You entered bad data.\nPlease try again.\n");
            }
            // 2. The program automatically continues looping after catching the error or finishing the math
        }
        
        scanner.close();
    }
}

    

