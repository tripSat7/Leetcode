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
    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        rob(root.left);
        rob(root.right);
        int robThisNode = root.val;
        int dontRobThisNode = 0;
        if (root.left != null) {
            dontRobThisNode += root.left.val;
            if (root.left.left != null) {
                robThisNode += root.left.left.val;
            }
            if (root.left.right != null) {
                robThisNode += root.left.right.val;
            }
        }
        if (root.right != null) {
            dontRobThisNode += root.right.val;
            if (root.right.left != null) {
                robThisNode += root.right.left.val;
            }
            if (root.right.right != null) {
                robThisNode += root.right.right.val;
            }
        }
        root.val = Math.max(robThisNode, dontRobThisNode);
        return root.val;
    }
}