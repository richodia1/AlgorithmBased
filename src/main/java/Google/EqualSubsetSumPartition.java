package Google;
/*
User
Equal subset sum partition
Problem statement: Given a set of positive numbers, find if we can partition it
into two subsets such that the sum of elements in both subsets is equal.
 */
public class EqualSubsetSumPartition {

    public static boolean canPartition(int[] nums) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        // If the total sum is odd, it cannot be partitioned into two equal subsets
        if (totalSum % 2 != 0) {
            return false;
        }

        int targetSum = totalSum / 2;
        int n = nums.length;

        // dp[i][j] will be 'true' if the sum 'j' is possible with the first 'i' numbers
        boolean[][] dp = new boolean[n + 1][targetSum + 1];

        // Sum of 0 is possible with all subsets, so set the first column to 'true'
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        // Fill the dp table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= targetSum; j++) {
                // If the current number is greater than the sum, it cannot be included
                if (nums[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // Include or exclude the current number
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }

        return dp[n][targetSum];
    }

    public static void main(String[] args) {
        // Example usage:
        int[] nums = {1, 5, 11, 5};
        boolean result = canPartition(nums);
        System.out.println("Can be partitioned into two subsets with equal sum: " + result);
    }
}

