class Solution {
    public int change(int amount, int[] coins) {

        int prev[] = new int[amount + 1];
        
        for(int i = 0; i <= amount; i++) {
            if(i % coins[0] == 0){
                prev[i] = 1;
            }
        }

        // Fill the prev array using dynamic programming
        for (int i = 1; i < coins.length; i++) {
            int[] cur = new int[amount + 1];
            for (int target = 0; target <= amount; target++) {
                int notTaken = prev[target];

                int taken = 0;
                if(coins[i] <= target){
                    taken = cur[target - coins[i]];
                }
                    
                cur[target] = notTaken + taken;
            }
            prev = cur;
        }

        return prev[amount];
    }
}