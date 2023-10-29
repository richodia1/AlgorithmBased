package slidingwindow2;

import java.util.Comparator;
import java.util.Map;

public class SlidingWindowCase1 {
    public static void main(String[] args) {
        Map<String, Integer> map = Map.of("A", 5, "B", 10, "C", 3, "D", 1);

        // Find the key with the highest value
        String keyWithMaxValue = map.entrySet()
                .stream()
                .max(Comparator.comparing(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .orElse(null);

        System.out.println("Key with the highest value: " + keyWithMaxValue);
    }

    /*
    Easy: Statically Sized Sliding Window: Given an array of integers,
    find maximum/minimum sum subarray of a given size
    Example Input: [-1, 2, 3, 1, -3, 2]
    Subarray Size: 2
     */
    public static int maxSumOfSize(int[] arr, int size){
        int start = 0, maxSum = Integer.MIN_VALUE, subSum = 0;
        for(int end = 0; end < arr.length; end++){
            subSum += arr[end];
            if(end >= size - 1){
                maxSum = Math.max(subSum,maxSum);
                subSum -= arr[start];
                start++;
            }
        }
        return maxSum;
    }
    public static int minSumOfSize(int[] arr, int size){

        int start = 0, minSum = Integer.MIN_VALUE, subSum = 0;
        for(int end = 0; end < arr.length; end++){
            subSum += arr[end];
            if(end >= size - 1){
                minSum = Math.min(subSum,minSum);
                subSum -=arr[start];
                start++;

            }
        }
        return minSum;
    }
}
