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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
    return buildBinaryTree(postorder, 0 , postorder.length - 1, inorder, 0, inorder.length - 1);
    }
    
    public TreeNode buildBinaryTree(int[] postorder, int poststart, int postEnd, int inorder[], int inStart, int inEnd){
        if(poststart > postEnd || inStart > inEnd){
            return null;
        }
        int val = postorder[postEnd];
        TreeNode root = new TreeNode(val);
        
        int offset = inStart;
        
        while(offset < inEnd){
            if(inorder[offset] == val){
                break;
            }
            
            offset++;
        }
        
        root.left = buildBinaryTree(postorder, poststart, poststart + offset - inStart -1, inorder, inStart, offset - 1);
        root.right = buildBinaryTree(postorder, poststart + offset - inStart , postEnd - 1, inorder, offset+1, inEnd);
        
        
        return root;
    }
}