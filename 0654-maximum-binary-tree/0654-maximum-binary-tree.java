/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        
        return construct(nums, 0, nums.length - 1);
    }
    
    public TreeNode construct(int[] nums, int start, int end){
        
        if(start > end){
            return null;
        }
        
        int max = findMax(nums, start, end);
        TreeNode root = new TreeNode(nums[max]);
        
        root.left = construct(nums, start, max-1);
        root.right = construct(nums, max+1, end);
        
        return root;
    }
    
    public int findMax(int[] nums, int start, int end){
        int max = nums[start];
        int idx = start;
        for(int i = start; i <= end; i++){
            if(nums[i] > max){
                max = nums[i];
                idx = i;
            }
        }
        
        return idx;
    }
}