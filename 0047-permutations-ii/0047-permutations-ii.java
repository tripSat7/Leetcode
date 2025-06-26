// Time Complexity: O(n!)
// Space Complexity: O(n) for recursion stack (plus space for storing results)

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums); // Sort to make duplicate checking easy
        backtrack(res, new ArrayList<>(), nums, new boolean[nums.length]);
        return res;
    }

    // Helper for backtracking permutations
    private void backtrack(List<List<Integer>> res, List<Integer> tempList, int[] nums, boolean[] used) {
        if(tempList.size() == nums.length) {
            res.add(new ArrayList<>(tempList)); // Found a complete permutation
        } else {
            for(int i = 0; i < nums.length; i++) {
                // Skip already used numbers, or duplicates where the previous one wasn't used
                if(used[i] || (i > 0 && nums[i] == nums[i-1] && !used[i - 1])) {
                    continue;
                }
                used[i] = true;
                tempList.add(nums[i]);
                backtrack(res, tempList, nums, used); // Explore further
                used[i] = false; // Backtrack
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
