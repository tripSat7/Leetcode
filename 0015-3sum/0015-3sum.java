// Time Complexity: O(N^2)
//   - Outer loop: O(N)
//   - Inner two-pointer scan: O(N) for each i
// Space Complexity: O(N) (for sorting, if not in-place; otherwise, O(1) extra)

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums); 
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0)
            {
                break; // Since array is sorted, no need to check further
            } 

            if (i > 0 && nums[i] == nums[i - 1]){
                continue; // Skip duplicate values for i
            } 

            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum > 0) {
                    r--;
                } 
                else if (sum < 0) {
                    l++;
                } 
                else {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++;
                    r--;
                    // Skip duplicates for both pointers
                    while (l < r && nums[l] == nums[l - 1]) l++;
                    while (l < r && nums[r] == nums[r + 1]) r--;
                }
            }
        }
        return res;
    }
}
