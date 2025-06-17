// Time Complexity: O(amount * C), where C = number of coins
// Space Complexity: O(amount) for the dp array

public class Solution {
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1; // A sentinel value > any possible coin count
        int[] dp = new int[amount + 1];  
        Arrays.fill(dp, max);      
        dp[0] = 0; // Zero coins needed to make amount 0

        // Build dp table from 1 to amount
        for (int i = 1; i <= amount; i++) {
            // Try each coin for current sub-amount i
            for (int coin : coins) {
                if (coin <= i) {
                    // If we use this coin, we need 1 + dp[i - coin] coins
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        // If dp[amount] is still > amount, it means amount is unreachable
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
