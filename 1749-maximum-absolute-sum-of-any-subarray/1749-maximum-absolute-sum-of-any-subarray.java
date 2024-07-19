class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            sum = sum + num;
            max = Math.max(max, sum);
            if (sum < 0){
                sum = 0;
            }
        }

        int min = Integer.MAX_VALUE;
        sum = 0;
        for (int num : nums) {
            sum = sum + num;
            min = Math.min(min, sum);
            if (sum > 0){
                sum = 0;
            }
                
        }

        return Math.max(Math.abs(max), Math.abs(min));
    }
}