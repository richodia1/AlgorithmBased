package Leo;

import java.util.PriorityQueue;

public class KthSmallestAndLargestElement {
    public static void main(String[] args) {
        // Test case
        int[] nums = {3, 1, 4, 2, 7};
        int k = 3;

        int result = findKthSmallest(nums, k);
        System.out.println("The " + k + "th largest element is: " + result);
    }

    public static int findKthSmallest(int[] nums, int k) {
        // Create a max heap using PriorityQueue
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        // Add elements to the max heap
        for (int num : nums) {
            maxHeap.offer(num);

            // If the size of the heap exceeds k, remove the largest element
            if (maxHeap.size() > k) {
                var p = maxHeap.peek();
                maxHeap.poll();
            }
        }

        // The remaining element at the top of the heap is the kth smallest
        return maxHeap.peek();
    }
    public static int findKthLargest(int[] nums, int k) {
        // Create a min heap using PriorityQueue
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>();

        // Add elements to the max heap
        for (int num : nums) {
            maxHeap.offer(num);

            // If the size of the heap exceeds k, remove the largest element
            if (maxHeap.size() > k) {
                var p = maxHeap.peek();
                maxHeap.poll();
            }
        }

        // The remaining element at the top of the heap is the kth smallest
        return maxHeap.peek();
    }
}
