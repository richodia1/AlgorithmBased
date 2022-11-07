package algorithm.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class PairWithTagetTwoSUM {
    public static void main(String[] args) {
        int[] result = MultipleTwoTarget(new int[] { 1, 2, 3, 4, 6 }, 12);
        System.out.println("Pair with target Multiple: [" + result[0] + ", " + result[1] + "]");
        result = TwoSum(new int[] { 2, 5, 9, 11 }, 20);
        System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
    }
    public static int[] search(int[] arr, int targetSum) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int currentSum = arr[left] + arr[right];
            if (currentSum == targetSum)
                return new int[] { left, right }; // found the pair

            if (currentSum > targetSum)
                left++; // we need a pair with a bigger sum
            else
                right--; // we need a pair with a smaller sum
        }
        return new int[] { -1, -1 };
    }


    public static int[] MultipleTwoTarget(int[] arr, int targetSum) {
       int left = 0, right = arr.length - 1;
       while (left < right){
           int productOfTwo = arr[left] * arr[right];
           if(productOfTwo == targetSum){
               return new int[]{left, right};
           }
           if(targetSum > productOfTwo)
               left++;
               else
                   right--;

       }

        return new int[]{-1,-1};
    }
    public static int[] TwoSum(int[] arr, int targetSum) {
        Map<Integer, Integer> dict = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            int complement = targetSum - arr[i];
            if(dict.containsKey(complement) && dict.get(complement) != i){
                return new int[] {dict.get(complement),i};
            }
            if(!dict.containsKey(arr[i])){
                dict.put(arr[i],i);
            }
        }
        return new int[] { -1, -1 };
    }


}
