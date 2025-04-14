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

    int res;
    public int sumNumbers(TreeNode root) {
        res = 0;
        
        helper(root, 0);
        return res;
    }

    public void helper(TreeNode root, int val){

        if(root == null){
            return;
        }

        val = val * 10 + root.val;

        if(root.left == null && root.right == null){
            res += val;
            return;
        }

        helper(root.left, val);
        helper(root.right, val);

    }
}