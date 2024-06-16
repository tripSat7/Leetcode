class Solution {
    public int maxChunksToSorted(int[] arr) {
        
        int n = arr.length;
        int min[] = new int[n];
        min[n-1] = arr[n-1];
        for(int i = n-2; i >=0; i--){
            min[i] = Math.min(min[i+1],arr[i]);
        }
        
        int maxOfLeft = arr[0];
        int res = 0;
        for (int i = 0; i < n - 1; i++) {
            maxOfLeft = Math.max(maxOfLeft, arr[i]);
            if(maxOfLeft <= min[i + 1]) {
                res++;
            }
        }

        return res+1;
    }
}