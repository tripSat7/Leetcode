class Solution {
    public int[] productExceptSelf(int[] nums) {
        int numsLen = nums.length;
        int[] output = new int[numsLen];

        int currentPrefix = 1;
        output[0] = 1;
        for(int i = 1; i < numsLen; i++) {
            currentPrefix *= nums[i - 1];
            output[i] = currentPrefix;
        }

        int currentSuffix = 1;
        for(int i = numsLen - 2; i >= 0; i--) {
            currentSuffix *= nums[i + 1];
            output[i] *= currentSuffix;
        }

        return output;
    }
}