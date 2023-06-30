class Solution {
    public boolean validPalindrome(String s) {
        int left = 0; int right = s.length() -1;
        while (left < right) {
            char x = s.charAt(left);
            char y = s.charAt(right);
            if (x == y) {
                left++;
                right--;
                continue;
            }
            return isPal(s, left + 1, right) || isPal(s, left, right - 1);
        }
        return true;
    }
    private boolean isPal(String s, int left, int right) {
        while (left < right) {          
            char x = s.charAt(left);
            char y = s.charAt(right);
            if (x != y) {
                return false;
            }        
            left++;
            right--;
        }
        return true;
    }
}