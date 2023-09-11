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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        
        if(root == null){
            return false;
        }
        
        if(targetSum - root.val == 0 && (root.left == null && root.right == null)){
            return true;
        }
        
        int lts = targetSum;
        int rts = targetSum;
        
        boolean isL = hasPathSum(root.left, lts - root.val);
        boolean isR = hasPathSum(root.right, lts - root.val);
        
        return isL || isR;
    }
}