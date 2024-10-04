class Solution {
    public int rob(int[] arr) {
        int n = arr.length;
        
        if(n == 1){
            return arr[0];
        }
        if(n == 2){
            return arr[1] > arr[0] ? arr[1] : arr[0];
        }
        
        int dp[] = new int[n];
        dp[0] = arr[0];
        dp[1] = arr[1];
        int res = Math.max(arr[0], arr[1]);
        
        for(int i = 2; i < n; i++){
            int max = Integer.MIN_VALUE;
            for(int j = i - 2; j >= 0 ; j--){
                int cost = dp[j] + arr[i];
                max = Math.max(cost, max);
            }
    
            dp[i] = max;
            res = Math.max(res, max);
        }
        
        return res;
    }
}