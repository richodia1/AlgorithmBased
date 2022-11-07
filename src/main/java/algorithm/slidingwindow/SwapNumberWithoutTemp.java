package algorithm.slidingwindow;

import java.util.HashMap;

public class SwapNumberWithoutTemp {

    public static void main(String[] args){

         System.out.println(MostFrequest("Bolu many Bolu how many times I many call you"));
    }
    /*
    Design a method to find the frequency of occurrences of any given word in a
book. What if we were running this algorithm multiple times?
     */

    public static String MostFrequest(String sentence){
        String[] word = sentence.replace("  "," ").split(" ");
        HashMap<String, Integer> dic = new HashMap<>();
        for(int i = 0; i<word.length; i++){
            dic.put(word[i],dic.getOrDefault(word[i],0) + 1);
        }
        // look through the dictionary to get the
        int maxCount = 0;
        String maxCountWord = "";
        for(int j = 0; j < word.length; j++){
            if(dic.get(word[j]) > maxCount){
                maxCount = dic.get(word[j]);
                maxCountWord = word[j];
            }
        }
        return maxCountWord;
    }
}
