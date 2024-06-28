class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        int[] count = new int[150];
        for (int i = 0, j = 0; i < s.length(); i++) {
            count[s.charAt(i)]++;
            while (count[s.charAt(i)] > 1) {
                count[s.charAt(j++)]--;
            }
            ans = Math.max(ans, i - j + 1);
        }
        return ans;
    }
}