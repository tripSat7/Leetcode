class Solution {
    public int firstUniqChar(String s) {
        int[] freqCount = new int[26];

        for (char c : s.toCharArray()) {
            freqCount[c - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (freqCount[c - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }
}