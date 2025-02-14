class Solution {
    public int minInsertions(String s) {
        
        int res = longestCommonSubsequence(s, new StringBuilder(s).reverse().toString());

        return s.length() - res;
    }

    public int longestCommonSubsequence(String s1, String s2){
        int prev[] = new int[s1.length() + 1];
        prev[0] = 0;

        for(int i = 1; i <= s1.length(); i++){
            int cur[] = new int[s1.length() + 1];
            for(int j = 1; j <= s2.length(); j++){
                if(s1.charAt(i - 1) == s2.charAt(j - 1)){
                    cur[j] = 1 + prev[j - 1];
                }
                else{
                    cur[j] = Math.max(cur[j-1], prev[j]);
                }
            }
            prev = cur;
        }

        return prev[s1.length()];
    }
}