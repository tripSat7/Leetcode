// Time Complexity: O(N log k), where N is the number of unique words (since each offer/poll in the heap is O(log k))
// Space Complexity: O(N + k): O(N) for the frequency map, O(k) for the heap, O(k) for the result list

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> cnt = new HashMap<>();
        // Count the frequency of each word
        for (String word : words) {
            cnt.put(word, cnt.getOrDefault(word, 0) + 1);
        }

        // Min-heap based on frequency; for ties, use reverse lexicographical order
        PriorityQueue<String> h = new PriorityQueue<>(
            (w1, w2) -> cnt.get(w1).equals(cnt.get(w2)) ? w2.compareTo(w1) : cnt.get(w1) - cnt.get(w2)
        );

        // Maintain a heap of size k with top k frequent words
        for (String word : cnt.keySet()) {
            h.offer(word);
            if (h.size() > k) {
                h.poll(); // Remove the least frequent (or lexicographically largest in case of tie)
            }
        }

        // Build the result list from the heap (smallest/top word comes out first)
        List<String> res = new ArrayList<>();
        while (!h.isEmpty()) {
            res.add(h.poll());
        }
        Collections.reverse(res); // Since heap pops least frequent first, reverse for correct order
        return res;
    }
}
