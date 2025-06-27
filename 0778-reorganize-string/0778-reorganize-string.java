/*
    Time Complexity: O(N), where N = s.length()
    Space Complexity: O(N) for the result array

    Approach:
    - Count frequency of each character.
    - If the max frequency > (N + 1) / 2, it's impossible to reorganize (return "").
    - Place the most frequent character first, in every other spot (0, 2, 4, ...).
    - Fill remaining slots (even and then odd) with the rest.
    - This avoids adjacent duplicates.
*/

class Solution {
    public String reorganizeString(String s) {
        char[] freq = new char[26]; // Count for each character a-z

        int max = 0, letter = 0;
        // Count frequencies and find the character with max frequency
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            freq[ch - 'a']++;
            if (freq[ch - 'a'] > max) {
                max = freq[ch - 'a'];
                letter = ch - 'a';
            }
        }

        // Impossible if the max char appears more than (N+1)/2 times
        if (max > (s.length() + 1) / 2) {
            return "";
        }

        char[] res = new char[s.length()];
        int idx = 0;

        // Place the most frequent letter at even indices (0, 2, 4, ...)
        while (freq[letter] > 0) {
            res[idx] = (char) (letter + 'a');
            idx += 2;
            freq[letter]--;
        }

        // Place the rest of the letters
        for (int i = 0; i < freq.length; i++) {
            while (freq[i] > 0) {
                if (idx >= res.length) {
                    idx = 1; // Once even slots are filled, start filling odd slots
                }
                res[idx] = (char) (i + 'a');
                idx += 2;
                freq[i]--;
            }
        }

        return String.valueOf(res);
    }
}
