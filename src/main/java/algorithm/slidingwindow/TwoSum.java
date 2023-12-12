package algorithm.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static int[] findTwoSum(int[] nums, int target) {
        Map<Integer, Integer> numIndices = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (numIndices.containsKey(complement)) {
                // Found a pair that sums up to the target
                return new int[]{numIndices.get(complement), i};
            }

            numIndices.put(nums[i], i);
        }

        // No pair found
        return new int[]{-1,-1};
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] result = findTwoSum(nums, target);

        if (result != null) {
            System.out.println("Indices of two numbers that sum up to " + target + ": " + result[0] + " and " + result[1]);
        } else {
            System.out.println("No such numbers found.");
        }
    }
}

