package Google;
/*
Print balanced brace combinations
Problem statement: Print all braces combinations for a given value ‘N’ so that
they are balanced.
 */
public class BalancedBraces {

    // Function to print all balanced brace combinations
    public static void printBalancedBraces(int n) {
        printBalancedBracesHelper("", n, 0, 0);
    }

    // Helper function for recursion
    private static void printBalancedBracesHelper(String current, int n, int open, int close) {
        // Base case: if the length of the current string is 2 * N, print it
        if (current.length() == 2 * n) {
            System.out.println(current);
            return;
        }

        // Recursive case: add an open brace if the count of open braces is less than N
        if (open < n) {
            printBalancedBracesHelper(current + "(", n, open + 1, close);
        }

        // Recursive case: add a close brace if the count of close braces is less than open braces
        if (close < open) {
            printBalancedBracesHelper(current + ")", n, open, close + 1);
        }
    }

    public static void main(String[] args) {
        int n = 3; // Change the value of N as needed
        printBalancedBraces(n);
    }
}

