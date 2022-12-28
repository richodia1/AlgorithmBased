package slidingwindow2;

public class SlidingWindowCase1 {
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
