// Time Complexity: O(N)
// Space Complexity: O(N)
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        // Bucket sort: freq from 1 up to nums.length
        List<Integer>[] buckets = new List[nums.length + 1];
        for (int key : freq.keySet()) {
            int count = freq.get(key);
            if (buckets[count] == null){
                buckets[count] = new ArrayList<>();
            } 
            buckets[count].add(key);
        }
        List<Integer> result = new ArrayList<>();
        // Collect results from high frequency to low, stop at k
        for (int i = buckets.length - 1; i >= 0 && result.size() < k; i--) {
            if (buckets[i] != null) {
                for (int num : buckets[i]) {
                    result.add(num);
                    if (result.size() == k){
                        break;
                    } 
                }
            }
        }
        // Convert result list to int[]
        int[] topK = new int[k];
        for (int i = 0; i < k; i++) {
            topK[i] = result.get(i);
        }
        return topK;
    }

}