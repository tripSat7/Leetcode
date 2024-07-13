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
    public TreeNode pruneTree(TreeNode root) {
        
        // if(root.left == null && root.right == null && root.val == 0){
        //     return null;
        // }
        boolean left = helper(root.left);
        boolean right = helper(root.right);
        
        if(left == false){
            root.left = null;
        }
        
        if(right == false){
            root.right = null;
        }
        
        if(root.val == 0 && !left && !right){
            return null;
        }
        
        return root;
    }
    
    public boolean helper(TreeNode root){
        
        if(root == null){
            return false;
        }
        
        boolean left = helper(root.left);
        boolean right = helper(root.right);
        
        if(left == false){
            root.left = null;
        }
        
        if(right == false){
            root.right = null;
        }
        
        if(root.val == 0 && !left && !right){
            return false;
        }
        else{
            return true;
        }
    }
}