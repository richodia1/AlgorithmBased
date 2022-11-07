package algorithm.slidingwindow;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

/*
Problem Statement
Given a string s and a number k, find the maximum number of vowels in any substring of size k.

Vowels: ['a', 'e', 'i', 'o', 'u']
Example 1:

Input: s = "abciiidef", k = 3
Output: 3
Explanation: The substring "iii" contains 3 vowel letters.
Example 2:

Input: s = "aeiou", k = 2
Output: 2
Explanation: Any substring of length 2 contains 2 vowels.
Example 3:

Input: s = "leetcode", k = 3
Output: 2
Explanation: "lee", "eet" and "ode" contain 2 vowels.


Analysis
Time Complexity: O(n)
Space Complexity: O(1)
 */
public class MaximumNumberOfVowelsInString {
    @Test
    public void testPositive(){
        assertTrue(2 == maxKSubstringVowels("leetcode",3));
        assertTrue(2 == maxKSubstringVowels("aeiou",2));
    }

    int isVowel(char c) {
        if(c =='a' || c =='e' || c =='i' || c =='o' || c =='u'){
            return 1;
        }
        return 0;
    }

    int maxKSubstringVowels (String s, int k) {
        int n = s.length();
        int count = 0;
        for (int i = 0; i < k; i++) {
            count += isVowel(s.charAt(i));
        }

        int maxCount = count;
        for (int i = k; i < n; i++) {
            count = count - isVowel(s.charAt(i - k)) + isVowel(s.charAt(i));
            maxCount = Math.max(maxCount, count);
        }

        return maxCount;
    }
}
