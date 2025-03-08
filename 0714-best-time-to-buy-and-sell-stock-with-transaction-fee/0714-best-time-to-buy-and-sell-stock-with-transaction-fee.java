class Solution {
    public int maxProfit(int[] prices, int fee) {
        
        int dp[][] = new int[prices.length][2];

        for(int i = 0; i < prices.length; i++){
            Arrays.fill(dp[i], -1);
        }

        return helper(prices, fee, 0, 0, dp);
    }

    public int helper(int[] prices, int fee, int idx, int buy, int dp[][]){
        
        if(idx == prices.length){
            return 0;
        }

        if(dp[idx][buy] != -1){
            return dp[idx][buy];
        }

        int profit = 0;

        if(buy == 0){
            profit = Math.max(0 + helper(prices, fee, idx + 1, 0, dp), -prices[idx] + helper(prices, fee, idx + 1, 1, dp));
        }

        if(buy == 1){
            profit = Math.max(0 + helper(prices, fee, idx + 1, 1, dp), prices[idx] - fee + helper(prices, fee, idx + 1, 0, dp));
        }

        dp[idx][buy] = profit;

        return profit;
    }
}