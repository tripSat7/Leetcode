class Solution {
    public int numDistinct(String s, String t) {

        int lt = s.length();
        int ls = t.length();

        int dp[][] = new int[lt][ls];
        for (int rows[] : dp)
            Arrays.fill(rows, -1);

        // Call the recursive helper function to compute the count
        return countUtil(s, t, lt - 1, ls - 1, dp);
    }

    public int countUtil(String s1, String s2, int ind1, int ind2, int[][] dp) {
        // If we have exhausted s2, there's one valid subsequence (empty string) in s1.
        if (ind2 < 0)
            return 1;
        // If we have exhausted s1 but not s2, there are no valid subsequences.
        if (ind1 < 0)
            return 0;

        // If the result is already computed, return it.
        if (dp[ind1][ind2] != -1)
            return dp[ind1][ind2];

        // If the characters at the current positions match, we can either leave one character from s1
        // or continue to the next character in s1 while staying at the same character in s2.
        if (s1.charAt(ind1) == s2.charAt(ind2)) {
            int leaveOne = countUtil(s1, s2, ind1 - 1, ind2 - 1, dp);
            int stay = countUtil(s1, s2, ind1 - 1, ind2, dp);

            // Add the two possibilities and take modulo prime to avoid integer overflow.
            return dp[ind1][ind2] = (leaveOne + stay);
        } else {
            // If the characters don't match, we can only continue to the next character in s1.
            return dp[ind1][ind2] = countUtil(s1, s2, ind1 - 1, ind2, dp);
        }
    }
}