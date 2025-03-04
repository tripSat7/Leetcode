class Solution {
    public int maxProfit(int k, int[] prices) {

        int n = prices.length;
        int[][][] dp = new int[n][2][k + 1];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        
        return helper(prices, n, 0, 0, k, dp);
    }
    
    public static int helper(int[] prices, int n, int ind, int buy, int cap, int[][][] dp) {
        if (ind == n || cap == 0) {
            return 0;
        }
        
        if (dp[ind][buy][cap] != -1) {
            return dp[ind][buy][cap];
        }
        
        int profit;
        
        if (buy == 0) {
            profit = Math.max(0 + helper(prices, n, ind + 1, 0, cap, dp), -prices[ind] + helper(prices, n, ind + 1, 1, cap, dp));
        } else { 
            profit = Math.max(0 + helper(prices, n, ind + 1, 1, cap, dp), prices[ind] + helper(prices, n, ind + 1, 0, cap - 1, dp));
        }
        
        dp[ind][buy][cap] = profit;
        return profit;
    }
}