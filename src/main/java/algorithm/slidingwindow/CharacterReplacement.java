package algorithm.slidingwindow;

import java.util.*;
import java.util.stream.Stream;

/*
Given a string with lowercase letters only,
if you are allowed to replace no more than ‘k’ letters with any letter,
find the length of the longest substring having the same letters after replacement.
Example 1:
Input: String="aabccbb", k=2
Output: 5
Explanation: Replace the two 'c' with 'b' to have a longest repeating substring "bbbbb".
Example 2:
Input: String="abbcb", k=1
Output: 4
Explanation: Replace the 'c' with 'b' to have a longest repeating substring "bbbb".
Example 3:
Input: String="abccde", k=1
Output: 3
Explanation: Replace the 'b' or 'd' with 'c' to have the longest repeating substring "ccc".

 */
public class CharacterReplacement {



    public static int findRank( int[] arr, int k ){
        Arrays.sort( arr );

        // reversing the order
        for( int i = 0; i < arr.length / 2; i++ ){
            int temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }

        int[] rank = new int[ arr.length ];
        rank[0] = 1;

        for( int i = 1; i < rank.length; i++ ){
            if( arr[i] == arr[i-1] ) rank[i] = rank[i-1];
            else rank[i] = i + 1;

            if( rank[i] >= k ) return i;
        }
        return arr.length;
    }
    /*
     * Complete the 'maximumOccurringCharacter' function below.
     *
     * The function is expected to return a CHARACTER.
     * The function accepts STRING text as parameter.
     */

    public static char maximumOccurringCharacter(String text) {
        char rtn = 'a';
        Map<Character, Integer>  charFreq = new HashMap<>();


        for(int i = 0; i < text.length(); i ++){


            charFreq.put(text.charAt(i),charFreq.getOrDefault(text.charAt(i),0) +1);
        }
        int counter = 0;
        for(Map.Entry<Character, Integer> entry : charFreq.entrySet()){
            if(entry.getValue() > counter){
                counter = entry.getValue();
                rtn = entry.getKey();
            }
        }

        return rtn;

    }

    public static int findLength(String str, int k) {
        int maxLenght = Integer.MAX_VALUE; int start = 0;
        Map<Character,Integer> charFreq = new HashMap<>();
        for(int end = 0; end < str.length(); end++){
            char ch = str.charAt(end);
            charFreq.put(ch,charFreq.getOrDefault(ch,0) +1);

            while (charFreq.size() > k){
                char chs = str.charAt(start);
                charFreq.put(chs,charFreq.getOrDefault(chs,0) - 1);
                if(charFreq.get(chs) == 0){
                    charFreq.remove(chs);
                }
                start++;
            }
              maxLenght = Math.max(maxLenght,end - start +1 );

        }
        return maxLenght;
    }

/*
1.3 URLify: Write a method to replace all spaces in a string with '%2e: You may assume that the string
has sufficient space at the end to hold the additional characters, and that you are given the "true"
length of the string. (Note: if implementing in Java, please use a character array so that you can
perform this operation in place.)
EXAMPLE
Input: "Mr John Smith JJ, 13
Output: "Mr%2eJohn%2eSmith"
 */
public static String replaceStringChar(String str){
    StringBuilder builder = new StringBuilder();
    String[] words = str.split(" ");
    for(int i = 0; i < words.length; i++){

        builder.append(words[i]);
        if(i != words.length -1)
            builder.append("%2e");

    }
    return builder.toString();
}

public static void main(String[] args) {

    //int[] list = {5,6,6,1,4,2};
    //int count = (int) Stream.of(1, 2, 3, 4, 5)
           // .filter(i -> i <4) // Intermediate Operation filter
            //.count(); // Terminal Operation count
   // Random random = new Random();

   // random.ints().limit(5).forEach(System.out::println);
    System.out.println(replaceStringChar("Mr John Smith"));
    System.out.println();
}

}
