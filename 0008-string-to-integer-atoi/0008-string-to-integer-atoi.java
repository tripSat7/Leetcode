// TC : O(N)
// SC : O(1)
class Solution {
    public int myAtoi(String input) {
        int sign = 1;
        int res = 0;
        int index = 0;
        int n = input.length();

        // Discard all spaces from the beginning of the input string.
        while (index < n && input.charAt(index) == ' ') {
            index++;
        }

        // sign = +1, if it's positive number, otherwise sign = -1.
        if (index < n && input.charAt(index) == '+') {
            sign = 1;
            index++;
        } 
        else if (index < n && input.charAt(index) == '-') {
            sign = -1;
            index++;
        }

        // Traverse next digits of input and stop if it is not a digit
        while (index < n && Character.isDigit(input.charAt(index))) {
            int digit = input.charAt(index) - '0';

            // Check overflow(res * 10 case in line 36) and underflow conditions.
            if ((res > Integer.MAX_VALUE / 10) ||
                (res == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) 
            {
                // If integer overflowed return 2^31-1, otherwise if underflowed return -2^31.
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            // Append current digit to the result.
            res = 10 * res + digit;
            index++;
        }

        // We have formed a valid number without any overflow/underflow.
        // Return it after multiplying it with its sign.
        return sign * res;
    }
}