package codebyteinterview;


import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RotateArrayLeftKthPosition {
public static void main(String[] args){
    String str1 = "aaaaaay";
    String str2 = "bbbbbbz";

    System.out.println(longestOne(str1,str2));
    //int[] arr = {1,2,3,4,5,6};
 // var result =  rotate(arr,5);
  //  for(int t :arr) System.out.println(t);
}
    public static String longestOne(String s1, String s2) {
        String s = s1 + s2;
        return s.chars().distinct().sorted().collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
    }
    public static String longest (String s1, String s2) {
        // your code
        StringBuilder builder = new StringBuilder();
        String joined = s1 + s2;

        //return joined.chars().distinct().sorted().collect(StringBuilder::new,StringBuilder::appendCodePoint,StringBuilder::append).toString();
        builder.append(joined.charAt(0));
        for(int i = 1; i < joined.length(); i++){
            if(!builder.toString().contains(Character.toString(joined.charAt(i))))
                builder.append(joined.charAt(i));
        }
        char[] arr = builder.toString().toCharArray();
        Arrays.sort(arr);
        return new String(arr);

    }
    public String spinWords(String sentence) {
        //TODO: Code stuff here
        if(!sentence.contains(" ")){
            return sentence.length() >= 5 ? reversedWord(sentence) : sentence;
        }
        StringBuilder result = new StringBuilder();

        String[] arr = sentence.split(" ");

        for(int i = 0; i < arr.length; i++){

            if(arr[i].length() > 4 && i < arr.length -1){
                result.append(reversedWord(arr[i])+" ");
            }else if(arr[i].length() > 4 && i == arr.length -1 ){
                result.append(reversedWord(arr[i]));
            }else if(arr[i].length() < 5 && i < arr.length-1){
                result.append(arr[i]+" ");
            }else if(arr[i].length() < 5 && i == arr.length - 1){
                result.append(arr[i]);
            }


        }
        return result.toString();
    }

    public String reversedWord(String word){
        StringBuilder builder = new StringBuilder();
        for(int i = word.length() -1; i >= 0; i--){
            builder.append(word.charAt(i));
        }
        return builder.toString();
    }

    public static int[] rotate(int[] a, int k){
        k = k % a.length;
        if(k < 0) k = k + a.length;
        reverse(a,0,a.length - k -1);
        reverse(a,a.length - k, a.length - 1);
        reverse(a,0,a.length - 1);
       return a;
    }
    public static void reverse(int[] a, int left, int right){
        while (left < right){
            int temp = a[left];
            a[left] = a[right];
            a[right] = temp;
            left++;
            right--;
        }
    }
}
