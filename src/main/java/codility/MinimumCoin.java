package codility;

import java.util.Arrays;


public class MinimumCoin {
    public static void main(String[] args){
        var result = minCoins(new int[]{1,3,4,4,5}, 4);
        System.out.println((result));
    }
    public static int minCoins(int[] coins, int target) {
        int[] dp = new int[target + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= target; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    int sub = dp[i - coin];
                    if (sub != Integer.MAX_VALUE) {
                        dp[i] = Math.min(dp[i], sub + 1);
                    }
                }
            }
        }
        return dp[target] == Integer.MAX_VALUE ? -1 : dp[target];
    }

}
