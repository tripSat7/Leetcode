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
    int res, count;
    public int kthSmallest(TreeNode root, int k) {
        
        res = root.val;
        count = k;
        helper(root);
        return res;
    }
    
    public void helper(TreeNode root){
        
        if(root == null){
            return;
        }
        
        helper(root.left);
        count--;
        if(count==0){
            res = root.val;
        }
        helper(root.right);
        
    }
}