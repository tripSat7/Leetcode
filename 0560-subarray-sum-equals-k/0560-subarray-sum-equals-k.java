class Solution {
    public int subarraySum(int[] nums, int k) {
        int length = nums.length;
        int[] prefix = new int[length + 1];
        prefix[0] = 0;

        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += nums[i];
            prefix[i + 1] = sum;
        }

        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i <= length; i++) {
            count += map.getOrDefault(prefix[i] - k, 0);
            map.put(prefix[i], map.getOrDefault(prefix[i], 0) + 1);
        }

        return count;
    }
}