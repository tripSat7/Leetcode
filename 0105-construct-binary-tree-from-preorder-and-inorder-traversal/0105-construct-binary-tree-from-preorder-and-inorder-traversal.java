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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        return buildBinaryTree(preorder, 0 , preorder.length - 1, inorder, 0, inorder.length - 1);
    }
    
    public TreeNode buildBinaryTree(int[] preorder, int prestart, int preEnd, int inorder[], int inStart, int inEnd){
        if(prestart > preEnd || inStart > inEnd){
            return null;
        }
        int val = preorder[prestart];
        TreeNode root = new TreeNode(val);
        
        int offset = inStart;
        
        while(offset < inEnd){
            if(inorder[offset] == val){
                break;
            }
            
            offset++;
        }
        root.left = buildBinaryTree(preorder, prestart+1, prestart + offset - inStart, inorder, inStart, offset - 1);
        root.right = buildBinaryTree(preorder, prestart + offset - inStart + 1, preEnd, inorder, offset+1, inEnd);
        
        
        return root;
    }
}