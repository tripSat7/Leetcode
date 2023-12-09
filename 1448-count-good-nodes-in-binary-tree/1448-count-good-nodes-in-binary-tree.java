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
    int res = 0;
    public int goodNodes(TreeNode root) {
        helper(root, Integer.MIN_VALUE);
        return res;
    }
    
    public void helper(TreeNode root, int max){
        if(root == null){
            return;
        }
        if(root.val >= max){
            //System.out.println(root.val);
            res++;
            max = root.val;
        }
        helper(root.left, max);
        helper(root.right, max);
    }
}