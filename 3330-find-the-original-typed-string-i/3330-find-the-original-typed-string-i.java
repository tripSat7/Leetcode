class Solution {
    public int possibleStringCount(String word) {
        int res = 1;
        int i = 0;
        
        while (i < word.length()) {
            int j = i;
            while (j < word.length() && word.charAt(j) == word.charAt(i)) {
                j++;
            }
            
            int segmentLength = j - i;
            res += segmentLength - 1;
            i = j;
        }
        
        return res;
    }
}