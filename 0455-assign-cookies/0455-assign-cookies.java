class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        int idx = 0;
        while (idx < s.length && count < g.length) {
            if (s[idx] >= g[count]) {
                count++;
            }
            idx++;
        }
        return count;
    }

}