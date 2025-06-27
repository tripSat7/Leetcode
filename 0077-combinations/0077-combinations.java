// Time Complexity: O(C(n, k) * k)
//   - There are C(n, k) combinations; each combination takes O(k) time to copy.
// Space Complexity: O(k) recursion stack depth (not counting output)
//   - Plus space for storing all combinations in res.

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), n, k, 0);
        return res; 
    }

    // Helper function to build combinations
    public void backtrack(List<List<Integer>> res, List<Integer> tempList, int n, int k, int start){
        if(tempList.size() == k){
            res.add(new ArrayList<>(tempList)); // Found a valid combination
            return;
        }

        for(int i = start; i < n; i++){
            tempList.add(i+1); // Choose the next number (1-based)
            backtrack(res, tempList, n, k, i+1); // Move to next index
            tempList.remove(tempList.size() - 1); // Backtrack
        }
    }
}
