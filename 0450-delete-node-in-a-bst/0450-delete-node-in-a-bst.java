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
    public TreeNode deleteNode(TreeNode root, int key) {
        
        if(root == null){
            return null;
        }
        
        
        if(key == root.val){
            if(root.left == null){
                return root.right;
            }
            else if(root.right == null){
                return root.left;
            }
            else{
                TreeNode left = root.left;
                TreeNode right = root.right;
                TreeNode temp = left;
                temp = helper(temp);
                temp.right = right;
                root = left;
            }            
        }
        else if(key < root.val){
            root.left = deleteNode(root.left, key);
        }
        else{
            root.right = deleteNode(root.right, key);
        }
        return root;
    }
    
    
    public TreeNode helper(TreeNode root){
        if(root.right == null){
            return root;
        }
        
        return helper(root.right); 
    }
}