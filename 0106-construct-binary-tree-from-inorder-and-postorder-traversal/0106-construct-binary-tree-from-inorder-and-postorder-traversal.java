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
    int postJ;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postJ = postorder.length - 1;
        return solve(inorder, postorder, 0, inorder.length - 1);
    }
    
    TreeNode solve(int[] inorder, int[] postorder, int inI, int inJ) {
        if(inI > inJ) return null;
        TreeNode node = new TreeNode(postorder[postJ]);
        int k;
        for(k = inJ; k >= inI; k--) {
            if(inorder[k] == postorder[postJ]) break;
        }
        postJ--;
        node.right = solve(inorder, postorder, k + 1, inJ);
        node.left = solve(inorder, postorder, inI, k - 1);
        return node;
    }
}