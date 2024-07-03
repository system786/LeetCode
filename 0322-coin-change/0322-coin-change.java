class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE; 
        }

        for (int target = 1; target <= amount; target++) {
            for (int c = 0; c < coins.length; c++) {
                if (target - coins[c] >= 0 && dp[target - coins[c]] != Integer.MAX_VALUE)
                    dp[target] = Math.min(dp[target], 1 + dp[target - coins[c]]);
            }
        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}