class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int[][] dp = new int[n][m];
        for (int row[] : dp){
            Arrays.fill(row, -1);
        }
            
        return editDistanceUtil(word1, word2, n - 1, m - 1, dp);
    }

    int editDistanceUtil(String s1, String s2, int i, int j, int[][] dp) {
        
        if (i < 0){
            return j + 1;
        }
            
        if (j < 0){
            return i + 1;
        }
            
        if (dp[i][j] != -1){
            return dp[i][j];
        }
            

        if (s1.charAt(i) == s2.charAt(j)){
            return dp[i][j] = editDistanceUtil(s1, s2, i - 1, j - 1, dp);
        }
            

        // Minimum of three choices:
        // 1. Replace the character in S1 with the character in S2.
        // 2. Delete the character in S1.
        // 3. Insert the character from S2 into S1.
        else{
            return dp[i][j] = 1 + Math.min(editDistanceUtil(s1, s2, i - 1, j - 1, dp),
                    Math.min(editDistanceUtil(s1, s2, i - 1, j, dp), editDistanceUtil(s1, s2, i, j - 1, dp)));
        }
            
    }
}