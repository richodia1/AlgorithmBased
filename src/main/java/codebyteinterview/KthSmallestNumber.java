package codebyteinterview;

import java.util.*;

public class KthSmallestNumber {
    public static void main(String[] args) {
      int[] arr ={1,5,12,2,11,5};
      int k =3;

      System.out.println("The Kth Largest is : " + KthLargestNumber(arr,2));
        System.out.println("The Kth smallest is : " + KthSmallestNumber(arr,2));

    }

        public static int KthLargestNumber(int[] nums, int k) {  // O(nlogK) time complexity
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i = 0; i < nums.length; i++){
            minHeap.add(nums[i]);
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }
        System.out.println("Min heap instance finally : "+minHeap);
        return minHeap.peek();
    }
    public static int KthSmallestNumber(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < nums.length;i++){
            maxHeap.add(nums[i]);
            if(maxHeap.size() > k){
                maxHeap.poll();
            }
        }
        System.out.println("Max heap instance finally : "+maxHeap);
        return maxHeap.peek();
    }


}
