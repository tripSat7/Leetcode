class Solution {
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        int res[][] = new int[nums.length/3][3];

        for(int i = 0; i < nums.length; i++){
            int row = i/3;
            if(!(nums[i+2] - nums[i] <= k)){
                return new int[][]{};
            }

            for(int j = 0; j < 3; j++){
                res[row][j] = nums[i++];
            }
            i--;
        }

        return res;
    }
}