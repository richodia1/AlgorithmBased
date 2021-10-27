package codebyteinterview;
import java.util.*;
import java.io.*;
public class LongestString {

    public static void main(String[] args){

        String str = "This is goingTo home";
        System.out.println(longestWord(str));
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
