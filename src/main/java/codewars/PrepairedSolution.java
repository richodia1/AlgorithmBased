package codewars;

import javax.print.attribute.standard.NumberOfInterveningJobs;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class PrepairedSolution {
    public static void main(String[] args){
        var result = binarySearch(new int[] {2,4,5,5,5,5,5,7,9,9},1);
        System.out.println(result);
    }

    public static boolean IsAnagram(String str1, String str2){
        if(str1 == null || str2 == null) return false;
        if(str1.length() !=str2.length()) return false;
        Map<Character, Integer> charFreqMap1 = new HashMap<>();
        Map<Character, Integer> charFreqMap2 = new HashMap<>();
        for(int i =0; i< str1.length(); i++){
            charFreqMap1.put(str1.charAt(i),charFreqMap1.getOrDefault(str1.charAt(i),0)+1);
            charFreqMap2.put(str2.charAt(i),charFreqMap2.getOrDefault(str2.charAt(i),0)+1);
        }
        for(int i =0; i< str1.length(); i++){
            if(!Objects.equals(charFreqMap2.get(str2.charAt(i)),charFreqMap1.get(str1.charAt(i)))){
                return false;
            }
        }
        return true;
    }

    public static int[] TwoPointer(int[] arr, int target){
        Map<Integer, Integer> dict = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            int complimment = target - arr[i];
            if(dict.containsKey(complimment) && arr[i] != i){
                return new int[]{dict.get(complimment),i};
            }else {
                dict.put(arr[i],i);
            }
        }
        return new int[]{-1,-1};
    }
    public static int reverse(int num){
        int reversed = 0;
        while(num > 0){
            reversed = reversed * 10 + num % 10;
            num /=10;
        }
        return reversed;
    }

    public static int binarySearch(int[] arr, int target){
        int left = 0, right = arr.length - 1;
        while (left < right){
            int mid = (left + right)/2;
            if(arr[mid] == target){
                return mid;
            }else if(arr[mid] < target){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
