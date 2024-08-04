class Solution {
    public int maxScore(int[] arr, int k) {
        
        int n = arr.length;
        int maxSum = 0;
        for(int i = n - k; i < n; i++) {
            maxSum += arr[i];
        }
        int endPointer = 0;
        int windowSum = maxSum;
        for(int i = n - k; i < n; i++) {
            windowSum -= arr[i]; 
            windowSum += arr[endPointer++];
            if(windowSum > maxSum){
                maxSum = windowSum;  
            } 
        }
        
        return maxSum;
    }
}