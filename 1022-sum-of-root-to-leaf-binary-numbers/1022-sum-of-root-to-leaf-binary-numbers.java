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
    int sum = 0;
    public int sumRootToLeaf(TreeNode root) {
        
        helper(root,0);
        
        return sum;
    }
    
    public void helper(TreeNode root, int bin){
        if(root == null){
            return;
        }
        int res = (bin<<1) + root.val;
        if(root.left == null && root.right == null){
            sum = sum + res;
        }
        
        helper(root.left, res);
        helper(root.right, res);
    }
}