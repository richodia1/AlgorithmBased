package algorithm.slidingwindow;
/*
Permutation in a String (hard)#
Given a string and a pattern, find out if the string contains any permutation of the pattern.
Permutation is defined as the re-arranging of the characters of the string.
For example, “abc” has the following six permutations:
1.	abc
2.	acb
3.	bac
4.	bca
5.	cab
6.	cba
If a string has ‘n’ distinct characters, it will have n!n! permutations.
Example 1:
Input: String="oidbcaf", Pattern="abc"
Output: true
Explanation: The string contains "bca" which is a permutation of the given pattern.
Example 2:
Input: String="odicf", Pattern="dc"
Output: false
Explanation: No permutation of the pattern is present in the given string as a substring.
Example 3:
Input: String="bcdxabcdy", Pattern="bcdyabcdx"
Output: true
Explanation: Both the string and the pattern are a permutation of each other.
Example 4:
Input: String="aaacb", Pattern="abc"
Output: true
Explanation: The string contains "acb" which is a permutation of the given pattern.

 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringPermutationPattern {
    public static boolean findPermutation(String str, String pattern) {
        int windowStart = 0, matched = 0;
        Map<Character, Integer> charFrequencyMap = new HashMap<>();
        for (char chr : pattern.toCharArray())
            charFrequencyMap.put(chr, charFrequencyMap.getOrDefault(chr, 0) + 1);

        // our goal is to match all the characters from the 'charFrequencyMap' with the current window
        // try to extend the range [windowStart, windowEnd]
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            if (charFrequencyMap.containsKey(rightChar)) {
                // decrement the frequency of the matched character
                charFrequencyMap.put(rightChar, charFrequencyMap.get(rightChar) - 1);
                if (charFrequencyMap.get(rightChar) == 0) // character is completely matched
                    matched++;
            }

            if (matched == charFrequencyMap.size())
                return true;

            if (windowEnd >= pattern.length() - 1) { // shrink the window by one character
                char leftChar = str.charAt(windowStart++);
                if (charFrequencyMap.containsKey(leftChar)) {
                    if (charFrequencyMap.get(leftChar) == 0)
                        matched--; // before putting the character back, decrement the matched count
                    // put the character back for matching
                    charFrequencyMap.put(leftChar, charFrequencyMap.get(leftChar) + 1);
                }
            }
        }

        return false;
    }

    public static List<String> Print(String[] words){
        List<String> toPrint= new ArrayList<>();

        for(int i = 0; i < words.length; i++){
            if(words[i].contains("print")){
                char[] validPring = words[i].toCharArray();
                char chToPrint = validPring[validPring.length - 2];
                String lookUpToPrint = "";
                for(int j = 0; j < i; j++){
                    if(words[j].contains(String.valueOf(chToPrint)+"=")){
                        lookUpToPrint = words[j];
                    }
                }
                if(lookUpToPrint != ""){
                    String[] arr = lookUpToPrint.split("=");
                    toPrint.add(arr[1]);
                }else{
                    toPrint.add(null);
                }
            }
        }
        return toPrint;
    }

    public static void main(String[] args) {
        String[] inputArray = {
                "{",
                "a=10",
                "print(a)",
                "{",
                "c=30",
                "}",
                "{",
                "print(a)",
                "print(b)",
                "b=20",
                "print(b)",
                "{",
                "a=40",
                "print(b)",
                "print(a)",
                "print(c)",
                "}",
                "print(a)",
                "}",
                "print(b)",
                "}"
        };
        var result = Print(inputArray);
        for(String str : result){
            System.out.println(str);
        }
    }

}
