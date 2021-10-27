package algorithm.slidingwindow;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Problem Statement#
Given an array of characters where each character represents a fruit tree,
you are given two baskets, and your goal is to put maximum number of fruits in each basket.
The only restriction is that each basket can have only one type of fruit.
You can start with any tree, but you can’t skip a tree once you have started.
You will pick one fruit from each tree until you cannot,
 i.e., you will stop when you have to pick from a third fruit type.
Write a function to return the maximum number of fruits in both baskets.
Example 1:
Input: Fruit=['A', 'B', 'C', 'A', 'C']
Output: 3
Explanation: We can put 2 'C' in one basket and one 'A' in the other from the subarray ['C', 'A', 'C']
Example 2:
Input: Fruit=['A', 'B', 'C', 'B', 'B', 'C']
Output: 5
Explanation: We can put 3 'B' in one basket and two 'C' in the other basket.
This can be done if we start with the second letter: ['B', 'C', 'B', 'B', 'C']

 */
public class MaxFruitCountOf2Types {

    public static void main(String[] args) {
       // System.out.println(findSubstringInWraproundString("101101"));
        List<String> strs = frag("50552");
        for(var st : strs){
            System.out.println(st);
        }
      //  System.out.println("Maximum number of fruits: " +
              //  MaxFruitCountOf2Types.findLength(new char[] { 'A', 'B', 'C', 'A', 'C' }));
       // System.out.println("Maximum number of fruits: " +
             //   MaxFruitCountOf2Types.findLength(new char[] { 'A', 'B', 'C', 'B', 'B', 'C' }));
    }
    public int canThreePartsEqualSum(int[] A) {
        int sum = 0;

        for (int n : A)
            sum += n;
        //check if it's divisible by 3
        if (sum % 3 != 0)
            return 0;
        //exact sum of each segment
        sum /= 3;

        int curSum = 0;
        int numOfSegments = 0;
        for (int i = 0; i < A.length; i++) {
            curSum += A[i];
            //check if we can form a segment
            if (curSum == sum && numOfSegments <= 1) {
                numOfSegments++;
                curSum = 0;
            }
        }
         return numOfSegments;
    }

    public static int findLength(char[] arr) {
        int windowStart = 0, maxLength = 0;
        Map<Character, Integer> fruitFrequencyMap = new HashMap<>();
        // try to extend the range [windowStart, windowEnd]
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            fruitFrequencyMap.put(arr[windowEnd], fruitFrequencyMap.getOrDefault(arr[windowEnd], 0) + 1);
            // shrink the sliding window, until we are left with '2' fruits in the frequency map
            while (fruitFrequencyMap.size() > 2) {
                fruitFrequencyMap.put(arr[windowStart], fruitFrequencyMap.get(arr[windowStart]) - 1);
                if (fruitFrequencyMap.get(arr[windowStart]) == 0) {
                    fruitFrequencyMap.remove(arr[windowStart]);
                }
                windowStart++; // shrink the window
            }
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }

        return maxLength;
    }
    //////////////////////////////////////////////////////////////////////

    public static int findSubstringInWraproundString(String p) {
        List<String> strs = frag(p);
        int largestNum = 0;
        for( String str : strs){
            int num = Integer.parseInt(str);
            if(num > largestNum){
                largestNum =num;
            }
        }
        return largestNum;
    }

    public static List<String> frag(String str){
        List<String> strs = new ArrayList<>();

        for (int i = 0; i < str.length()-1; i++) {
            strs.add(Character.toString(str.charAt(i))+ Character.toString(str.charAt(i+1)));
        }
         return strs;

    }

    private static List<String> fragment(String p) {
        List<String> strs = new ArrayList<>();
        int lastEnd = -1;
        while (lastEnd + 1 < p.length()) {
            StringBuffer sb = new StringBuffer();
            sb.append(p.charAt(lastEnd + 1));
            int candidate = lastEnd + 2;
            for (; candidate < p.length(); candidate++) {
                char ch1 = p.charAt(candidate - 1);
                char ch2 = p.charAt(candidate);
                if ((ch2 == ch1 + 1) || (ch1 == 'z' && ch2 == 'a')) {
                    sb.append(ch2);
                } else {
                    break;
                }
            }
            lastEnd = candidate - 1;
            strs.add(sb.toString());
        }
        return strs;
    }

}
