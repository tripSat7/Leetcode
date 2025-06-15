// TC : O(n)
// SC : O(1)
class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];         // Frequency of each uppercase character
        int maxFreq = 0;                  // Max frequency of any character in current window
        int start = 0, res = 0;
        char[] ch = s.toCharArray();

        for (int end = 0; end < ch.length; end++) {
            freq[ch[end] - 'A']++;
            maxFreq = Math.max(maxFreq, freq[ch[end] - 'A']);

            // Shrink window if replacements needed exceed k
             while( (end+1) - start - maxFreq > k){
                freq[ch[start] - 'A']--;
                start++;
            }

            // Update the max length of valid window
            res = Math.max(res, ((end + 1) - start) );
        }

        return res;
    }
}

/* AABABBA, k = 1
    start       End     MaxFreq     res 
    0           0       1           1
    0           1       2           2
    0           2       2           3
    0           3       3           4
    0           4       3           4
    1           5       3           4
*/