class Solution {
    public int maxProfit(int[] prices) {
        int low = Integer.MAX_VALUE;
        int res = 0, prof = 0, cp = 0, i;
        for(i = 0; i < prices.length - 1; i++){
            if(prices[i] < low){
                low = prices[i];
            }
            cp = prices[i] - low;
            if(cp > prof && prices[i+1] > prices[i]){
                prof = cp;
            }
            else if(cp > prof && prices[i+1] < prices[i]){
                res = res + cp;
                prof = 0;
                low = Integer.MAX_VALUE;
            }
        }
        
        if(low < Integer.MAX_VALUE && prices[i] >= prices[i-1]){
            res = res + (prices[i] - low);
        }
        return res;
    }
}