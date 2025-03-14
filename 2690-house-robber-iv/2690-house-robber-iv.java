class Solution {

    public int minCapability(int[] nums, int k) {

        int low = 1;
        int high = Arrays.stream(nums).max().getAsInt();
        int n = nums.length;

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