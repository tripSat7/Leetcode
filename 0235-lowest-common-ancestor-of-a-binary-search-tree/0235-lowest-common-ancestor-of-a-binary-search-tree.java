/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if (root == null) {
            return null;
        }

        int small = Math.min(p.val, q.val);
        int large = Math.max(p.val, q.val);

        if (large < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } 
        else if(small > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        } 
        else{
            return root;
        }

    }
}