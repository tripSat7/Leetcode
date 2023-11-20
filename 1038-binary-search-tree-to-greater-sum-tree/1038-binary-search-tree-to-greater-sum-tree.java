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
    private int max = 0;
    public TreeNode bstToGst(TreeNode root) {
        if(root == null){
            return null;
        }
        TreeNode right = bstToGst(root.right);
    
        root.val = max + root.val;
        max = root.val;
        TreeNode left = bstToGst(root.left); 
        
        return root;
    }
}