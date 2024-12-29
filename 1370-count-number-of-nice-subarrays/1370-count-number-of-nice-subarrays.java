class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int res = 0, curSum = 0;
        Map<Integer, Integer> prefixSums = new HashMap<>();
        prefixSums.put(0, 1);

        for (int num : nums) {
            
            curSum += (num % 2 == 0 ? 0 : 1);
            int diff = curSum - k;
            res += prefixSums.getOrDefault(diff, 0);
            prefixSums.put(curSum, prefixSums.getOrDefault(curSum, 0) + 1);
        }

        return res;
        
    }
}