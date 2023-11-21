package Leo;

import java.util.PriorityQueue;

public class KthLargestElementFinder {
    private final PriorityQueue<Integer> minHeap;
    private final int k;

    public KthLargestElementFinder(int k, int[] nums) {
        this.k = k;
        this.minHeap = new PriorityQueue<>(k);
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        if (minHeap.size() < k) {
            minHeap.offer(val);
        } else if (val > minHeap.peek()) {
            minHeap.poll();
            minHeap.offer(val);
        }
        return minHeap.peek();
    }

    public static void main(String[] args) {
        int k = 3;
        int[] nums = {4, 5, 8, 2};
        KthLargestElementFinder finder = new KthLargestElementFinder(k, nums);
        System.out.println("Size is now : "+ finder.minHeap.size());
        System.out.println(finder.add(3)); // Output: 4  //4, 5, 8, 2,3
        System.out.println(finder.add(5)); // Output: 5
        System.out.println(finder.add(10)); // Output: 5
        System.out.println(finder.add(9)); // Output: 8
        System.out.println(finder.add(4)); // Output: 8
    }
}

