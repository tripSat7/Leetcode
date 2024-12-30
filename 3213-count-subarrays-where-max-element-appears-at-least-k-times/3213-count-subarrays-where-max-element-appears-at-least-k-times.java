class Solution {
    public long countSubarrays(int[] nums, int k) {
        long res = 0;
        int l = 0, r = 0, cnt = 0, max = 0;
        for(int num : nums){
            max = Math.max(max, num);
        }

        while(r < nums.length){
            if(nums[r] == max){
                cnt++;
            }

            while (cnt >= k) {
                res += nums.length - r;
                if (nums[l] == max) {
                    cnt--; 
                }
                l++;
            }
            
            //System.out.println(l+"::"+r+"||"+res);
            r++;
        }

        return res;
    }
}