// Time Complexity: O(N * M * 4^L), 
//   N = number of rows, M = columns, L = max length of word
//   For each cell, explore up to 4^L paths (L = max word length, since you prune longer paths)
// Space Complexity: O(W + L + N*M), 
//   W = total number of words (for HashMap/Set), 
//   L = max word length (for call stack and current string), 
//   N*M for visited array per DFS call

class Solution {
    HashMap<String, Integer> map = new HashMap<>(); // Stores all words for fast lookup
    Set<String> ans = new HashSet<>(); // Stores found words to avoid duplicates
    int max = -1; // Max word length for pruning

    public List<String> findWords(char[][] board, String[] words) {
        // Build lookup map and find max word length
        for (String word : words) {
            map.put(word, 1);
            max = Math.max(max, word.length());
        }
        int n = board.length, m = board[0].length;
        // Start DFS from every cell
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                boolean[][] visited = new boolean[n][m];
                check(i, j, "", board, visited);
            }
        }

        return new ArrayList<>(ans);
    }

    // DFS from (i, j) building up 'str'
    public void check(int i, int j, String str, char[][] board, boolean[][] visited) {
        // Out of bounds, already visited, or exceeded max word length
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || visited[i][j] || str.length() >= max) {
            return;
        }
        visited[i][j] = true;
        str += board[i][j];

        // If the current string is a word, add to answer set
        if (map.containsKey(str)) {
            ans.add(str);
        }

        // Explore all four directions
        check(i - 1, j, str, board, visited);
        check(i + 1, j, str, board, visited);
        check(i, j - 1, str, board, visited);
        check(i, j + 1, str, board, visited);

        // Backtrack: unmark current cell
        visited[i][j] = false;
    }
}
