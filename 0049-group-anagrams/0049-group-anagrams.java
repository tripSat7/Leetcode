// Time Complexity: O(N*KlogK), where N = number of strings, K = max string length
// Space Complexity: O(NK) for the hashmap and result storage

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0){
            return new ArrayList();
        } 
        Map<String, List> ans = new HashMap<String, List>();
        
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca); //K * logK
            String key = String.valueOf(ca);
            if (!ans.containsKey(key)){
                ans.put(key, new ArrayList());
            } 
            ans.get(key).add(s);
        }

        return new ArrayList(ans.values());
    }
}
