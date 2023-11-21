package Google;

import java.util.PriorityQueue;

public class KthLargestElement {

    private PriorityQueue<Integer> minHeap;
    private int k;

    public KthLargestElement(int[] nums, int k) {
        this.k = k;
        this.minHeap = new PriorityQueue<>(k);

        for (int num : nums) {
            add(num);
        }
    }

    public int add(int num) {
        if (minHeap.size() < k) {
            minHeap.offer(num);
        } else if (num > minHeap.peek()) {
            minHeap.poll();
            minHeap.offer(num);
        }

        return minHeap.peek();
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 8, 2};
        int k = 3;

        KthLargestElement kthLargest = new KthLargestElement(nums, k);

        System.out.println("Kth Largest Element after adding 3: " + kthLargest.add(3));
        System.out.println("Kth Largest Element after adding 5: " + kthLargest.add(5));
        System.out.println("Kth Largest Element after adding 10: " + kthLargest.add(10));
        System.out.println("Kth Largest Element after adding 9: " + kthLargest.add(9));
        System.out.println("Kth Largest Element after adding 4: " + kthLargest.add(4));
    }
}

