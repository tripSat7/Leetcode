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
public class Solution {
    public int pseudoPalindromicPaths(TreeNode root) {
        int[] count = new int[10];
        return dfs(root, count, 0);
    }

    private int dfs(TreeNode cur, int[] count, int odd) {
        if (cur == null){
            return 0;
        } 

        count[cur.val] ^= 1;
        odd += count[cur.val] == 1 ? 1 : -1;

        int res = (cur.left == null && cur.right == null && odd <= 1) ? 1 
                  : dfs(cur.left, count, odd) + dfs(cur.right, count, odd);

        odd += count[cur.val] == 1 ? 1 : -1;
        count[cur.val] ^= 1;

        return res;
    }
}