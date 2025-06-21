// Time Complexity: O(N), where N is the length of the string s
// Space Complexity: O(N), for the stack in case of deeply nested parentheses

class Solution {
    public int calculate(String s) {
        if (s == null) return 0;

        int len = s.length();
        int sign = 1;         // Current sign (+1 or -1)
        int ans = 0;          // Running total/result
        int currNo = 0;       // Number being processed
        Stack<Integer> stack = new Stack<>(); // Stores ans and sign for nested expressions

        for (int i = 0; i < len; i++) {
            if (Character.isDigit(s.charAt(i))) {
                // Parse multi-digit numbers
                currNo = s.charAt(i) - '0';
                while (i + 1 < len && Character.isDigit(s.charAt(i + 1))) {
                    currNo = currNo * 10 + s.charAt(i + 1) - '0';
                    i++;
                }
                currNo = currNo * sign; // Apply sign to current number
                ans += currNo;
                currNo = 0;
                sign = 1; // Reset sign after using it
            } 
            else if (s.charAt(i) == '+') {
                sign = 1;
            }
            else if (s.charAt(i) == '-') {
                sign = -1;
            }
            else if (s.charAt(i) == '(') {
                stack.push(ans); // store the result calculated so far
                stack.push(sign); // store the upcoming sign
                ans = 0;
                sign = 1;
            } 
            else if (s.charAt(i) == ')') {
                // Pop sign and previous result, combine with current result
                int prevSign = stack.pop();
                ans = prevSign * ans;
                int prevAns = stack.pop();
                ans = ans + prevAns;
            }
        }

        return ans;
    }
}
