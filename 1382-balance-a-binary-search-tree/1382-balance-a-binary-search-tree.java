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
    List<TreeNode> inorder = new ArrayList<>();
    
    public TreeNode balanceBST(TreeNode root) {
        inOrderTraversal(root);
        return helper(inorder, 0, inorder.size()-1);
    }
    
    public TreeNode helper(List<TreeNode> inorder, int start, int end){
        if(start>end){
            return null;
        }
        
        if(start == end){
            TreeNode root = inorder.get(start);
            root.left = null;
            root.right = null;
            
            return root;
        }
        
        int mid = (start+end)/2;
        TreeNode root = inorder.get(mid);
        root.left = helper(inorder, start, mid-1);
        root.right = helper(inorder, mid+1, end);
        
        return root;
    }
    
    public void inOrderTraversal(TreeNode root){
        if(root == null){
            return;
        }
        
        inOrderTraversal(root.left);
        inorder.add(root);
        inOrderTraversal(root.right);
    }
}