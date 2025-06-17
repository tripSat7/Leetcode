// Time Complexity: O(s.length + t.length)
// Space Complexity: O(t.length) for character frequency map

class Solution {
    public String minWindow(String s, String t) {
        // If s is shorter than t, it's impossible to find a window
        if (s.length() < t.length()) {
            return "";
        }

        // Count frequency of each character in t
        Map<Character, Integer> charCount = new HashMap<>();
        for (char ch : t.toCharArray()) {
            charCount.put(ch, charCount.getOrDefault(ch, 0) + 1);
        }

        int targetCharsRemaining = t.length(); // total characters we need to match
        int[] minWindow = {0, Integer.MAX_VALUE}; // store start and end of the smallest window
        int startIndex = 0;

        // Expand the window from left to right
        for (int endIndex = 0; endIndex < s.length(); endIndex++) {
            char ch = s.charAt(endIndex);

            // If current character is required decrease the remaining count
            if (charCount.containsKey(ch) && charCount.get(ch) > 0) {
                targetCharsRemaining--;
            }

            // Decrease the count of the current character in the map
            charCount.put(ch, charCount.getOrDefault(ch, 0) - 1);

            // When we have a valid window
            if (targetCharsRemaining == 0) {
                // Try to shrink the window from the left
                while (true) {
                    char charAtStart = s.charAt(startIndex);
                    // Stop shrinking if removing this character breaks the window
                    if (charCount.containsKey(charAtStart) && charCount.get(charAtStart) == 0) {
                        break;
                    }
                    charCount.put(charAtStart, charCount.getOrDefault(charAtStart, 0) + 1);
                    startIndex++;
                }

                // Update the result if this window is smaller
                if (endIndex - startIndex < minWindow[1] - minWindow[0]) {
                    minWindow[0] = startIndex;
                    minWindow[1] = endIndex;
                }

                // Prepare for the next window by removing start character
                charCount.put(s.charAt(startIndex), charCount.getOrDefault(s.charAt(startIndex), 0) + 1);
                targetCharsRemaining++;
                startIndex++;
            }
        }

        // Return the smallest valid window, or empty string if none found
        return minWindow[1] >= s.length() ? "" : s.substring(minWindow[0], minWindow[1] + 1);
    }
}
