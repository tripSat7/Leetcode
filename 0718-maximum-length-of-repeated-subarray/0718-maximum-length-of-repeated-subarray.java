class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int prev[] = new int[m + 1];
        int res = 0;
        for(int i = 1; i <= m; i++){
            int cur[] = new int[m + 1];
            for(int j = 1; j <= n; j++){
                if(nums1[i-1] == nums2[j-1]){
                    int val = 1 + prev[j-1];
                    cur[j] = val;
                    res = Math.max(val, res);
                }
                else{
                    cur[j] = 0;
                }
            }
            prev = cur;
        }

        return res;
    }
}