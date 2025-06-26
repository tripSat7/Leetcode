// Time Complexity: O(2^T), where T is the target value (worst-case, due to recursion)
// Space Complexity: O(T) for recursion stack (plus space for storing all valid combinations in the output list)

class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        
        backtrack(res, new ArrayList<>(), nums, target, 0);
        return res;
    }

    // Helper function to build combinations recursively
    private void backtrack(List<List<Integer>> res, List<Integer> tempList, int[] nums, int remain, int start) {
        if(remain < 0) {
            return; // Exceeded the sum, stop exploring this path
        } 
        else if(remain == 0) {
            res.add(new ArrayList<>(tempList)); // Found a valid combination
        } 
        else { 
            
            for(int i = start; i < nums.length; i++) {
                tempList.add(nums[i]); // Choose nums[i]
                backtrack(res, tempList, nums, remain - nums[i], i); // Not i+1; reuse the same element
                tempList.remove(tempList.size() - 1); // Backtrack, remove last choice
            }
        }

    }

}
