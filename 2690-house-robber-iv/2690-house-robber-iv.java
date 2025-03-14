class Solution {

    public int minCapability(int[] nums, int k) {

        int n = nums.length;
        int low = nums[0];
        int high = nums[0];
        for(int i = 1; i < nums.length; i++){
            low = Math.min(low, nums[i]);
            high = Math.max(high, nums[i]);
        }

        while (low < high) {
            int mid = (low + high) / 2;
            int possibleThefts = 0;

            for (int i = 0; i < n; i++) {
                if (nums[i] <= mid) {
                    possibleThefts += 1;
                    i++;
                }
            }

            if (possibleThefts >= k){
                high = mid;
            } 
            else{
                low = mid + 1;
            } 
        }

        return low;
    }
}