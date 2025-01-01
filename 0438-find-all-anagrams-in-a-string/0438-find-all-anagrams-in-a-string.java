public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if (p.length() > s.length()) return new ArrayList<>();
        
        int[] pCount = new int[26];
        int[] sCount = new int[26];
        
        for (char c : p.toCharArray()) {
            pCount[c - 'a']++;
        }
        for (int i = 0; i < p.length(); i++) {
            sCount[s.charAt(i) - 'a']++;
        }
        
        List<Integer> res = new ArrayList<>();
        if (Arrays.equals(pCount, sCount)) res.add(0);
        
        int l = 0;
        for (int r = p.length(); r < s.length(); r++) {
            sCount[s.charAt(r) - 'a']++;
            sCount[s.charAt(l) - 'a']--;
            l++;
            if (Arrays.equals(pCount, sCount)) {
                res.add(l);
            }
        }
        
        return res;
    }
}