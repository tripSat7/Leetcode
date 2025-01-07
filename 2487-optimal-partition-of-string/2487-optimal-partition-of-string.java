class Solution {
    public int partitionString(String s) {
        int ans = 1, startIdx = 0;
        int[] lastseen = new int[26];
        Arrays.fill(lastseen, -1);

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (lastseen[c - 'a'] >= startIdx) {
                ans++;
                startIdx = i;
            }
            lastseen[c - 'a'] = i;
        }
        return ans;
    }
}