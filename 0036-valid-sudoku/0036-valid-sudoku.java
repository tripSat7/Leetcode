// Time Complexity: O(N^2)
// Space Complexity: O(N^2) (arrays of 9 sets, each holding at most 9 elements)

class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n = 9;
        // Arrays to track seen numbers for rows, columns, and 3x3 boxes
        HashSet<Character> rows[] = new HashSet[n];
        HashSet<Character> cols[] = new HashSet[n];
        HashSet<Character> boxes[] = new HashSet[n];
        
        // Initialize hash sets for each row, column, and box
        for(int i = 0; i < n; i++){
            rows[i] = new HashSet<Character>();
            cols[i] = new HashSet<Character>();
            boxes[i] = new HashSet<Character>();
        }

        // Check each cell
        for(int r = 0; r < n; r++){
            for(int c = 0; c < n; c++){
                char val = board[r][c];
                if(val == '.'){
                    continue; // Skip empty cells
                }
                // Check row
                if(rows[r].contains(val)){
                    return false;
                } 
                rows[r].add(val);

                // Check column
                if(cols[c].contains(val)){
                    return false;
                }
                cols[c].add(val);
                
                // Check 3x3 box
                int box = (r/3) * 3 + c/3;
                if(boxes[box].contains(val)){
                    return false;
                }     
                boxes[box].add(val);
            }
        }
        return true; // All checks passed
    }
}
