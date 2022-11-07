package algorithm.slidingwindow;
/*
Given a string s, find the length of the longest substring without repeating characters.



Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public static int lengthOfLongestSubstring(String str)
    {
        int n = str.length();
        int res = 0;

        for(int i = 0; i < n; i++)
        {

            boolean[] visited = new boolean[256];

            for(int j = i; j < n; j++)
            {
                if (visited[str.charAt(j)] == true)
                    break;

                else
                {
                    res = Math.max(res, j - i + 1);
                    visited[str.charAt(j)] = true;
                }
            }
            visited[str.charAt(i)] = false;
        }
        return res;
    }

}
