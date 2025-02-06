class Solution {
    public int change(int amount, int[] coins) {

        int dp[][] = new int[coins.length][amount + 1];

        for(int row[] : dp){
            Arrays.fill(row, -1);
        }
        helper(amount, coins, coins.length - 1, dp);

        return dp[coins.length - 1][amount];
    }

    public int helper(int amount, int[] coins, int i, int dp[][]){
        if(i == 0){
            if(amount % coins[0] == 0){
                return dp[i][amount] = 1;
            }
            else{
                return dp[i][amount] = 0;
            }
        }

        if(dp[i][amount] != -1){
            return dp[i][amount];
        }
        int notTake = helper(amount, coins, i - 1, dp);

        int take = 0;
        if(coins[i] <= amount){
            take = helper(amount - coins[i], coins, i, dp);
        }

        return dp[i][amount] = take + notTake;
    }
}