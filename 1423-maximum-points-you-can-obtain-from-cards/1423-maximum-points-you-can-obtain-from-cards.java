class Solution {
    public int maxScore(int[] arr, int k) {
        
        int n = arr.length;
        int lSum[] = new int[n + 1];
        int rSum[] = new int[n + 1];
        lSum[0] = 0;
        rSum[n-1] = 0;
        
        for(int i = 1; i <= n; i++){
            lSum[i] = lSum[i - 1] + arr[i - 1];
        }
        
        
        for(int i = n - 1; i >= 0; i--){
            rSum[i] = rSum[i + 1] + arr[i];
        }
        
        int max = 0, i = 0;
        
        while(i <= k){
            int sum = lSum[i] + rSum[n - k + i];
            max = Math.max(sum, max);
            i++;
        }
        
        return max;
    }
}