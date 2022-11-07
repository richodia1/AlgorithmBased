package codebyteinterview;

import java.util.Arrays;

public class TwoStringsArePermutations {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};

        System.out.println(findDuplicate(arr));
    }

    public static int findDuplicate(int[] nums) {
        //  Declare a variable where the answer will be stored.
        int ans = 0;
        //  Sort the Array (you may use different algoritm like merge sort or quick sort to do so).
        Arrays.sort(nums);
        // Itrate the array an check for duplicate number.
        for(int i = 1; i < nums.length; i++){
            //  Condition to check if the number is same.
            if(nums[i] == nums[i-1]){
                ans = nums[i];
            }
        }
        //  Return the ans.
        return ans;
    }
    public static boolean arePermutation(String str1, String str2){
        if(str1.length() != str2.length()){
            return false;
        }
        return sort(str1).equals(sort(str2));
    }

    public static String sort(String str){
        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
}
