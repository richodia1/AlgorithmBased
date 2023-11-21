package Google;
/*
Determine if the number is valid
Problem statement: Given an input string, determine if it makes a valid
number or not. For simplicity, assume that white spaces are not present in the
input.
 */
public class ValidNumber {

    public static boolean isValidNumber(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }

        // Remove leading and trailing whitespaces
        s = s.trim();

        boolean numberSeen = false;
        boolean pointSeen = false;
        boolean eSeen = false;
        boolean numberAfterE = true;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                numberSeen = true;
                numberAfterE = true;
            } else if (ch == '.') {
                if (pointSeen || eSeen) {
                    return false; // Multiple dots or dot after 'e' is not allowed
                }
                pointSeen = true;
            } else if (ch == 'e' || ch == 'E') {
                if (eSeen || !numberSeen) {
                    return false; // Multiple 'e' or 'e' without any digit before it is not allowed
                }
                eSeen = true;
                numberAfterE = false;
            } else if (ch == '+' || ch == '-') {
                if (i != 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') {
                    return false; // '+' or '-' should only appear at the beginning or after 'e'
                }
            } else {
                return false; // Invalid character
            }
        }

        return numberSeen && numberAfterE;
    }

    public static void main(String[] args) {
        // Example usage:
        String input = "  0.1e10 ";
        boolean result = isValidNumber(input);
        System.out.println("Is a valid number: " + result);
    }
}

