class Solution {
    public long countOfSubstrings(String word, int k) {
        return atLeastK(word, k) - atLeastK(word, k + 1);
    }

    private long atLeastK(String word, int k) {
        long ans = 0;
        int start = 0;
        int end = 0;
        HashMap<Character, Integer> vowelCount = new HashMap<>();
        int consonantCount = 0;

        while(end < word.length()) {
            char c = word.charAt(end);
            if(this.isVowel(c)) {
                vowelCount.put(c, vowelCount.getOrDefault(c, 0) + 1);
            } else {
                consonantCount++;
            }
            while(vowelCount.size() == 5 && consonantCount >= k) {
                ans += word.length() - end;
                char startC = word.charAt(start);
                if(isVowel(startC)) {
                    vowelCount.put(startC, vowelCount.get(startC) - 1);
                    if(vowelCount.get(startC) == 0) {
                        vowelCount.remove(startC);
                    }
                } else {
                    consonantCount--;
                }
                start++;
            }
            end++;
        }
        return ans;
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
} 