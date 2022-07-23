package codebyteinterview;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthSmallestNumber {
    public static void main(String[] args) {
      int[] arr ={5,1,6,3,7};
      int k =3;
        //System.out.println("The second largest is: " + findKthLargestNumber(arr,2));
      // System.out.println("The second smallest is: " + findKthSmallestNumber(arr,2));

        System.out.println("My own : "+findKthSmallestNumber(arr, 4));
        System.out.println("Thier own: "+findKthSmallestNumber(arr, 4));



    }
    public static int findKthSmallestNumber2(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[k-1];
    }

    public static int findKthSmallestNumber(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((n1, n2) -> n2 - n1);
        // put first k numbers in the max heap
        for (int i = 0; i < k; i++)
            maxHeap.add(nums[i]);
        System.out.println("The element pushed to the smallect Heap : " + maxHeap);
//   int[] arr ={5,1,6,3,7};
        // go through the remaining numbers of the array, if the number from
        // the array is smaller than the
        // top (biggest) number of the heap, remove the top number from heap and add the number from array
        for (int i = k; i < nums.length; i++) {
            if (nums[i] < maxHeap.peek()) {
                maxHeap.poll();
                maxHeap.add(nums[i]);
                System.out.println("Latest of the smallect Heap : " + maxHeap);
            }
        }

        // the root of the heap has the Kth smallest number
        return maxHeap.peek();
    }
    public static int findKthLargestNumber(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((n1, n2) -> n1 - n2);
        // put first k numbers in the max heap
        for (int i = 0; i < k; i++)
            maxHeap.add(nums[i]);
        System.out.println("The element pushed to the Largest Heap was: " + maxHeap);
        //   int[] arr ={5,1,6,3,7};
       // top (biggest) number of the heap, remove the top number from heap and add the number from array
        for (int i = k; i < nums.length; i++) {
            if (nums[i] > maxHeap.peek()) {
                maxHeap.poll();
                maxHeap.add(nums[i]);
                System.out.println("Latest lagest Heap is now : " + maxHeap);
            }
        }

        // the root of the heap has the Kth smallest number
        return maxHeap.peek();
    }


}
