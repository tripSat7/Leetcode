// Time Complexity: O(log₁₀N) — Processes each digit of x 
// Space Complexity: O(1) — Uses only a few integer variables

class Solution {
    public int reverse(int x) {
        int rev = 0; // Stores the reversed number

        while (x != 0) {
            int pop = x % 10; // Extract the last digit
            x /= 10;          // Remove last digit from x

            // Check for positive overflow: if rev*10 + pop would exceed Integer.MAX_VALUE
            // (last digit of max int is 7)
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0; // Would overflow positive int
            }

            // Check for negative overflow: if rev*10 + pop would be below Integer.MIN_VALUE
            // (last digit of min int is -8)
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0; // Would overflow negative int
            }

            rev = rev * 10 + pop; 
        }
        
        return rev;
    }
}
