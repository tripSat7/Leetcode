// Time Complexity: O(amount * coins.length) — each sub-amount is solved once, looping over all coins
// Space Complexity: O(amount) — dp array of size amount+1 and recursion stack up to amount deep

public class Solution {
    public int coinChange(int[] coins, int amount) {
        // dp[i] will hold the min coins needed for amount = i, -1 = uncomputed
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);

        int minCoins = dfs(amount, coins, dp);
        // If unreachable, return -1
        return minCoins == Integer.MAX_VALUE ? -1 : minCoins;
    }

    // Returns min coins to make 'amount', or Integer.MAX_VALUE if impossible
    public int dfs(int amount, int[] coins, int[] dp) {
        // Base case: zero amount needs zero coins
        if (amount == 0) {
            return 0;
        }

        // Return cached result if already computed
        if (dp[amount] != -1) {
            return dp[amount];
        }

        int res = Integer.MAX_VALUE;
        // Try each coin
        for (int coin : coins) {
            if (amount - coin >= 0) {
                int result = dfs(amount - coin, coins, dp);
                // Only update if subproblem was solvable
                if (result != Integer.MAX_VALUE) {
                    res = Math.min(res, 1 + result);
                }
            }
        }

        // Memoize and return
        dp[amount] = res;
        return res;
    }
}
