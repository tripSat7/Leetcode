class Solution {
    public int[][] divideArray(int[] nums, int k) {
        int n = nums.length;
        List<int[]> ans = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < n; i += 3) {
            if (nums[i + 2] - nums[i] <= k) {
                ans.add(new int[]{ nums[i], nums[i + 1], nums[i + 2] });
            } else {
                return new int[0][0];
            }
        }
        return ans.toArray(new int[0][0]);
    }
}