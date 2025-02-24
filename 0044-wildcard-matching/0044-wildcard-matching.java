class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();

        int dp[][] = new int[n][m]; 
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return wildcardMatchingUtil(s, p, n - 1, m - 1, dp) == 1;
    }

    public boolean isAllStars(String S, int i) {
        for (int j = 0; j <= i; j++) {
            if (S.charAt(j) != '*') {
                return false;
            }
        }
        return true;
    }

    public int wildcardMatchingUtil(String S1, String S2, int i, int j, int[][] dp) {
        if(i < 0 && j < 0){
            return 1;
        } 

        if(i < 0 && j >= 0){
            return isAllStars(S2, j) ? 1 : 0; 
        } 

        if(j < 0 && i >= 0){
            return 0;
        }  

        if (dp[i][j] != -1){
            return dp[i][j];
        } 

        if(S1.charAt(i) == S2.charAt(j) || S2.charAt(j) == '?'){
            return dp[i][j] = wildcardMatchingUtil(S1, S2, i - 1, j - 1, dp);
        } 
        else if(S2.charAt(j) == '*'){
            return dp[i][j] = (wildcardMatchingUtil(S1, S2, i, j - 1, dp) == 1 || wildcardMatchingUtil(S1, S2, i - 1, j, dp) == 1) ? 1 : 0;
        } 
        else {
            return 0;
        }
    }
}
