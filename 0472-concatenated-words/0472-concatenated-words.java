// Time Complexity: O(N * L^2), where N is the number of words and L is the maximum word length.
//   - For each word, try all possible splits (O(L)) and recurse for each suffix (up to O(L)), so worst case O(L^2) per word.
//   - Can be optimized to O(N * L^2) with memoization.
// Space Complexity: O(N * L) for recursion stack and for storing all words in the set.

class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Set<String> set = new HashSet<>();
        List<String> concatenateWords = new ArrayList<>();
        
        // Add all words to the set for O(1) lookups
        for (String word : words) {
            set.add(word);
        }
        
        // Check each word if it can be formed by concatenating other words
        for (String word : words) {
            // Use a memo map for each word to avoid recomputation on substrings
            Map<String, Boolean> memo = new HashMap<>();
            
            if (checkConcatenate(word, set, memo)) {
                concatenateWords.add(word);
            }
            
        }
        return concatenateWords;
    }

    // Helper function: checks if word can be formed by concatenating other words in set
    public boolean checkConcatenate(String word, Set<String> set, Map<String, Boolean> memo) {
        if (memo.containsKey(word)){
            return memo.get(word);
        } 

        // Try every possible split (prefix + suffix)
        for (int i = 1; i < word.length(); i++) {
            String prefixWord = word.substring(0, i);
            String suffixWord = word.substring(i);

            // If prefix is in set and (suffix is in set OR suffix can be formed recursively)
            if (set.contains(prefixWord) && (set.contains(suffixWord) || checkConcatenate(suffixWord, set, memo))){
                memo.put(word, true);
                return true;
            }
        }

        memo.put(word, false);
        return false;
    }
}
