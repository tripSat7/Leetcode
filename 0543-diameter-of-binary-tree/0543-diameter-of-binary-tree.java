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
    int ans = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        
        findHeight(root);
        return ans;
    }
    
    public int findHeight(TreeNode root){
        if(root == null){
            return 0;
        }
        
        int ld = findHeight(root.left);
        int rd = findHeight(root.right);
        
        ans = Math.max(ans, ld+rd);
        
        return 1+Math.max(ld,rd);
    }
}