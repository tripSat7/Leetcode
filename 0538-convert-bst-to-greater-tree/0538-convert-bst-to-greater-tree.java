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
    int max = 0;
    public TreeNode convertBST(TreeNode root) {
        
        helper(root);
        return root;
    }
    
    public void helper(TreeNode root){
        
        if(root == null){
            return;
        }
        
        helper(root.right);
        max += root.val;
        root.val = max;
        helper(root.left);
    }
}