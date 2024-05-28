class Solution {
    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int n=nums.length;
        int count=0;
        for(int i=0;i<n;i++){
            if(nums[i] %2 ==0 && nums[i]<=threshold){
                int j=i+1;
                while(j < n && nums[j] <= threshold && (nums[j] % 2 != nums[j - 1] % 2)){
                    j++;
                }
                count=Math.max(count,j-i);
            }
            else continue;
        }
        return count;
    }
}