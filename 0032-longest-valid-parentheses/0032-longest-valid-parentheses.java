// Time Complexity : O(n)
// Space Complexity : O(1)

public class Solution {
    public int longestValidParentheses(String s) {
        int left = 0, right = 0, maxlength = 0;

        // Left to right scan
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;    // count open brackets
            } else {
                right++;   // count close brackets
            }

            if (left == right) {
                maxlength = Math.max(maxlength, 2 * right); // valid substring found
            } 
            else if (right > left) {
                left = right = 0;  // reset if unbalanced
            }
        }

        left = right = 0;

        // Right to left scan (to catch cases like "(()")
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }

            if (left == right) {
                maxlength = Math.max(maxlength, 2 * left); // valid substring found
            } 
            else if (left > right) {
                left = right = 0;  // reset if unbalanced
            }
        }

        return maxlength;
    }
}
