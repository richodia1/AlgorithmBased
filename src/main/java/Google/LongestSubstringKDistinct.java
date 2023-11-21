package Google;

import java.util.HashMap;
import java.util.Map;
/*
Longest substring with no more than ‘k’ distinct characters
Problem statement: Given a string, find the length of the longest substring in
it with no more than K distinct characters.
 */
public class LongestSubstringKDistinct {
    public static int longestSubstring(String s, int k) {
        if (s == null || s.length() == 0 || k <= 0) {
            return 0;
        }

        int maxLength = 0;
        int start = 0;
        Map<Character, Integer> charFrequency = new HashMap<>();

        for (int end = 0; end < s.length(); end++) {
            char currentChar = s.charAt(end);
            charFrequency.put(currentChar, charFrequency.getOrDefault(currentChar, 0) + 1);

            while (charFrequency.size() > k) {
                char startChar = s.charAt(start);
                charFrequency.put(startChar, charFrequency.get(startChar) - 1);
                if (charFrequency.get(startChar) == 0) {
                    charFrequency.remove(startChar);
                }
                start++;
            }

            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        // Example usage:
        String input = "eceba";
        int k = 2;
        int result = longestSubstring(input, k);
        System.out.println("Length of the longest substring with at most " + k + " distinct characters: " + result);
    }
}

