// Time Complexity: O(n * m) → n = length of word1, m = length of word2
// Space Complexity: O(n * m) → 2D DP table

class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        // dp[i][j] = min operations to convert word1[0..i-1] to word2[0..j-1]
        int[][] dp = new int[n + 1][m + 1];

        // Base cases: converting to or from an empty string
        for (int i = 0; i <= n; i++) {
            dp[i][0] = i;  // delete all characters from word1
        }
        for (int j = 0; j <= m; j++) {
            dp[0][j] = j;  // insert all characters of word2
        }

        // Fill the table bottom-up
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    // Characters match → no operation needed
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // Choose min of: insert, delete, replace
                    dp[i][j] = 1 + Math.min(
                        dp[i - 1][j - 1], // replace
                        Math.min(
                            dp[i - 1][j],   // delete
                            dp[i][j - 1]    // insert
                        )
                    );
                }
            }
        }

        return dp[n][m]; // final answer: convert full word1 to word2
    }
}
