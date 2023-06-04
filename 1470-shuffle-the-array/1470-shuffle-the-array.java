class Solution {
    public int[] shuffle(int[] nums, int n) {
        int res[] = new int[2*n];
        for(int i = 0, j = 0;i<n&&j<2*n;i++,j=j+2){
            res[j] = nums[i];
            res[j+1] = nums[i+n];
        }
        
        return res;
    }
}