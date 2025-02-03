class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;

        int prev[] = new int[amount + 1];
        
        for (int i = 0; i <= amount; i++) {
            if (i % coins[0] == 0)
                prev[i] = i / coins[0];
            else
                prev[i] = (int)1e9;
        }

        for (int i = 1; i < n; i++){

            int temp[] = new int[amount + 1];
            for (int target = 0; target <= amount; target++) {
                int notTake = 0 + prev[target];
                int take = (int) 1e9;

                if (coins[i] <= target){
                    take = 1 + temp[target - coins[i]];
                }
                    
                temp[target] = Math.min(notTake, take);
            }

            prev = temp;
        }

        int ans = prev[amount];

        if (ans >= (int) 1e9){
            return -1;
        }
            
        return ans;

    }
}