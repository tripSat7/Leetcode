// Time Complexity: O(N) 
// Space Complexity: O(1)

public class Solution {
    public int maxArea(int[] height) {
        int maxarea = 0;
        int left = 0;
        int right = height.length - 1;  

        
        while (left < right) {
            int width = right - left;    // Width between the two lines

            // Area is the shorter of the two heights times the width
            maxarea = Math.max(
                maxarea,
                Math.min(height[left], height[right]) * width
            );

            // Move the pointer at the shorter line inward,
            // since moving the taller one cannot increase area
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxarea;
    }
}
