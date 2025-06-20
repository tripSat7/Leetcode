// TC : O(n), n = length of string
// SC : O(1)

// Intuition: when a smaller value appears before a larger value, it represents subtraction, 
// and while when a smaller value appears after or equal to a larger value, it represents addition.
class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> m = new HashMap<>();
        
        m.put('I', 1);
        m.put('V', 5);
        m.put('X', 10);
        m.put('L', 50);
        m.put('C', 100);
        m.put('D', 500);
        m.put('M', 1000);
        
        int ans = 0;
        
        // Iterate through the string, checking for subtraction cases
        for (int i = 0; i < s.length(); i++) {
            // If the current character is less than the next, subtract it (e.g., IV, IX)
            if (i < s.length() - 1 && m.get(s.charAt(i)) < m.get(s.charAt(i + 1))) {
                ans -= m.get(s.charAt(i));
            } else {
                // Otherwise, add its value
                ans += m.get(s.charAt(i));
            }
        }
        
        return ans;
    }
}