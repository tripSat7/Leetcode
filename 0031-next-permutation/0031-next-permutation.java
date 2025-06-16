// TC : O(n)
// SC : O(1)
public class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;

        // Step 1: Find the first decreasing element from the end
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        // Step 2: If such element exists, find the next larger element on its right and swap
        if (i >= 0) {
            int j = nums.length - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }

        // Step 3: Reverse from i+1
        reverse(nums, i + 1);
    }

    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

// 2, 1, 5, 4, 3, 0, 0 
// Step 1: find the first decreasing element from the end -> 2, 1 [found], 5, 4, 3, 0, 0
// Step 2: find the next larger element on its right and swap -> 2, 3, 5, 4, 1, 0, 0 
// Step 3: Reverse from i+1 : 2, 3, 0, 0, 1, 4, 5