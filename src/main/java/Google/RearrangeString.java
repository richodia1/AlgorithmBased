package Google;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
/*
Longest substring with no repeating characters
Problem statement: Given a string, find if its letters can be rearranged in such
a way that no two same characters come next to each other.
 */
public class RearrangeString {
    public static String rearrangeString(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }

        Map<Character, Integer> charFrequency = new HashMap<>();
        for (char c : s.toCharArray()) {
            charFrequency.put(c, charFrequency.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>(
                (a, b) -> b.getValue() - a.getValue()
        );

        maxHeap.addAll(charFrequency.entrySet());

        StringBuilder result = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> current = maxHeap.poll();
            if (result.length() == 0 || result.charAt(result.length() - 1) != current.getKey()) {
                result.append(current.getKey());
                current.setValue(current.getValue() - 1);
                if (current.getValue() > 0) {
                    maxHeap.offer(current);
                }
            } else {
                Map.Entry<Character, Integer> next = maxHeap.poll();
                if (next == null) {
                    return ""; // No valid rearrangement possible
                }
                result.append(next.getKey());
                next.setValue(next.getValue() - 1);
                if (next.getValue() > 0) {
                    maxHeap.offer(next);
                }
                maxHeap.offer(current);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        // Example usage:
        String input = "aaabc";
        String result = rearrangeString(input);
        System.out.println("Rearranged string: " + result);
    }
}

