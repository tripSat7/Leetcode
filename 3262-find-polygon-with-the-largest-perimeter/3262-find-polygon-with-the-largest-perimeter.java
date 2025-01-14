class Solution {
    public long largestPerimeter(int[] nums) {
        Arrays.sort(nums);

        long res = -1, sum = 0;
        for (int num : nums) {
            if (num < sum) {
                res = num + sum;
            }
            sum += num;
        }

        return res;
    }
}