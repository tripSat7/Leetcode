// Time Complexity: O(NK), where N = number of strings, K = max string length
// Space Complexity: O(NK) for the hashmap and result storage

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) {
            return new ArrayList();
        }

        Map<String, List> ans = new HashMap<>();
        int[] count = new int[26]; 

        for (String s : strs) {
            Arrays.fill(count, 0); // Reset count array for each word

            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }

            // Convert frequency array to a unique key (e.g., "#1#0#2..." for "abb")
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                sb.append('#'); // delimiter to avoid ambiguity (e.g., "11" vs "1#1")
                sb.append(count[i]);
            }
            String key = sb.toString();

            // Group strings by their frequency signature
            if (!ans.containsKey(key)) {
                ans.put(key, new ArrayList());
            }
            ans.get(key).add(s);
        }

        return new ArrayList(ans.values()); // Return grouped anagrams
    }
}
