public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        if (s.length() < 10) {
            return new ArrayList<>();
        }

        Map<String, Integer> mp = new HashMap<>();
        List<String> res = new ArrayList<>();

        for (int l = 0; l < s.length() - 9; l++) {
            String cur = s.substring(l, l + 10);
            mp.put(cur, mp.getOrDefault(cur, 0) + 1);
            if (mp.get(cur) == 2) {
                res.add(cur);
            }
        }

        return res;
    }
}