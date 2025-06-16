// Time Complexity: O(n * m) -> n and m are lengths of word1 and word2
// Space Complexity: O(n * m) for memoization table (dp)

class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        // Memoization table to store results of subproblems
        int[][] dp = new int[n][m];
        for (int[] row : dp) {
            Arrays.fill(row, -1); // -1 indicates uncomputed state
        }

        // Start recursion from the last character of both words
        return editDistanceUtil(word1, word2, n - 1, m - 1, dp);
    }

    int editDistanceUtil(String s1, String s2, int i, int j, int[][] dp) {
        // If s1 is exhausted, insert remaining characters of s2
        if (i < 0) return j + 1;

        // If s2 is exhausted, delete remaining characters of s1
        if (j < 0) return i + 1;

        // Return already computed result if exists
        if (dp[i][j] != -1) return dp[i][j];

        // If characters match, move to the previous characters
        if (s1.charAt(i) == s2.charAt(j)) {
            return dp[i][j] = editDistanceUtil(s1, s2, i - 1, j - 1, dp);
        }

        // If characters don't match, try:
        // 1. Replace (i-1, j-1)
        // 2. Delete from s1 (i-1, j)
        // 3. Insert into s1 (i, j-1)
        // Minimum of above three operations
        return dp[i][j] = 1 + Math.min(
            editDistanceUtil(s1, s2, i - 1, j - 1, dp),
            Math.min(
                editDistanceUtil(s1, s2, i - 1, j, dp),
                editDistanceUtil(s1, s2, i, j - 1, dp)
            )
        );
    }
}
