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
    public boolean isSymmetric(TreeNode root) {
        
        if((root.left == null && root.right== null)){
            return true;
        }
        
        if((root.left == null && root.right!= null) || (root.left != null && root.right== null) || root.left.val != root.right.val){
            return false;
        }
        
        return helper(root.left,root.right);
    }
    
    public boolean helper(TreeNode left, TreeNode right){
        
        if(left == null && right == null){
            return true;
        }
        
        if((left == null && right!=null) || (left != null && right==null) || left.val != right.val ) {
            return false;
        }
        
        return helper(left.left,right.right) && helper(left.right, right.left);
    }
}