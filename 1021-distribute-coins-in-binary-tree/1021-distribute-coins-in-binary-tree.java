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
    private int res;

    public int distributeCoins(TreeNode root) {
        res = 0;
        dfs(root);
        return res;
    }

    private int[] dfs(TreeNode cur) {
        if (cur == null) {
            return new int[]{0, 0};
        }

        int[] left = dfs(cur.left);
        int[] right = dfs(cur.right);

        int size = 1 + left[0] + right[0];
        int coins = cur.val + left[1] + right[1];
        res += Math.abs(size - coins);

        return new int[]{size, coins};
    }
}