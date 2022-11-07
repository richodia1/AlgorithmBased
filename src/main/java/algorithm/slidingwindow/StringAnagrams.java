package algorithm.slidingwindow;
/*
String Anagrams (hard)#
Given a string and a pattern, find all anagrams of the pattern in the given string.
Every anagram is a permutation of a string. As we know,
when we are not allowed to repeat characters while finding permutations of a string,
we get N!N! permutations (or anagrams) of a string having NN characters. For example,
here are the six anagrams of the string “abc”:
1.	abc
2.	acb
3.	bac
4.	bca
5.	cab
6.	cba
Write a function to return a list of starting indices of the anagrams of the pattern in the given string.
Example 1:
Input: String="ppqp", Pattern="pq"
Output: [1, 2]
Explanation: The two anagrams of the pattern in the given string are "pq" and "qp".
Example 2:
Input: String="abbcabc", Pattern="abc"
Output: [2, 3, 4]
Explanation: The three anagrams of the pattern in the given string are "bca", "cab", and "abc".

 */
import java.util.*;
import java.util.stream.Collectors;

public class StringAnagrams {

    public static void main(String[] args) {
var res = getAnagrams("Words are a sword in our era.");
for(var i : res)
        System.out.println(i);
    }
    public static List<String> getAnagrams(String text) {
        List<String> anagramResult = new ArrayList<>();
        Map<String, List<String>> maps = new HashMap<>();

        String[] words = RemoveSpecialChars(text).split(" ");

        for(String str : words){
            char[] arr = str.toLowerCase().toCharArray();
            Arrays.sort(arr);
            String cur = new String(arr);
            if(!maps.containsKey(cur))
                maps.put(cur,new ArrayList<String>());

            maps.get(cur).add(str);

        }

        for(var values : maps.entrySet()){

            var resultVal = values.getValue();
            if(resultVal.size() == 2){

                for( var input : resultVal){
                    anagramResult.add(input);
                }

            }
        }
        return anagramResult.stream().sorted()
                .collect(Collectors.toList());
    }
    public static String RemoveSpecialChars(String str)
    {
        String[] chars = new String[] { ",", ".", "/", "!", "@", "#", "$", "%", "^", "&", "*", "'", "\"", ";", "_", "(", ")", ":", "|", "[", "]", "?" };
        for (int i = 0; i < chars.length; i++)
        {
            if (str.contains(chars[i]))
            {
                str = str.replace(chars[i], "");
            }
        }

        return str;
    }
    public static List<Integer> findStringAnagrams(String str, String pattern) {

        int windowStart = 0, matched = 0;
        Map<Character, Integer> charFrequencyMap = new HashMap<>();
        for (char chr : pattern.toCharArray())
            charFrequencyMap.put(chr, charFrequencyMap.getOrDefault(chr, 0) + 1);

        List<Integer> resultIndices = new ArrayList<Integer>();
        // our goal is to match all the characters from the map with the current window
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            // decrement the frequency of the matched character
            if (charFrequencyMap.containsKey(rightChar)) {
                charFrequencyMap.put(rightChar, charFrequencyMap.get(rightChar) - 1);
                if (charFrequencyMap.get(rightChar) == 0)
                    matched++;
            }

            if (matched == charFrequencyMap.size()) // have we found an anagram?
                resultIndices.add(windowStart);

            if (windowEnd >= pattern.length() - 1) { // shrink the window
                char leftChar = str.charAt(windowStart++);
                if (charFrequencyMap.containsKey(leftChar)) {
                    if (charFrequencyMap.get(leftChar) == 0)
                        matched--; // before putting the character back, decrement the matched count
                    // put the character back
                    charFrequencyMap.put(leftChar, charFrequencyMap.get(leftChar) + 1);
                }
            }
        }

        return resultIndices;
    }



}
