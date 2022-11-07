package codebyteinterview;
import java.util.*;
import java.io.*;
public class LongestString {

    public static void main(String[] args){

        String str = "locomotive This is goingToUdoneria home market";
        System.out.println(longestWord2(str));
    }
    public static String longestWord2(String sen) {

        //  String reg = "\W";      //use this...
        String longestWord = "";
       int count =0;
       String[] words=sen.split(" ");
    for(int i = 0; i < words.length; i++){
        if(words[i].length() > count){
            longestWord = words[i];
            count = words[i].length();
        }
    }
        return longestWord ;

    }
  public static String longestWord(String sen) {

      //  String reg = "\W";      //use this...
        String reg = "W";
        String[] s = sen.split(reg);
        String max = "";

        for(String str : s){
            if(str.length() > max.length())
                max = str;
        }

        return max;

    }
}
