class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a, b) -> (nums1[a[0]] + nums2[a[1]]) - (nums1[b[0]] + nums2[b[1]])
        );
        List<List<Integer>> result = new ArrayList<>();
        
        for (int i = 0; i < nums1.length && i < k; i++) {
            minHeap.offer(new int[]{i, 0});
        }

        while (k > 0 && !minHeap.isEmpty()) {
            int[] cur = minHeap.poll();
            int i = cur[0];
            int j = cur[1];
            result.add(Arrays.asList(nums1[i], nums2[j]));

            if (j + 1 < nums2.length) {
                minHeap.offer(new int[]{i, j + 1});
            }
            k--;
        }

        return result;
    }
}