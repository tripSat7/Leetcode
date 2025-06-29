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
// TC : O(n) 
// SC : O(1)

public class Solution {
    int maxSum;

    public int maxPathSum(TreeNode root) {
        maxSum = root.val;
        dfs(root);
        return maxSum;
    }

    private int dfs(TreeNode root) {
        if (root == null){
            return 0;
        } 
        int left = Math.max(dfs(root.left), 0);
        int right = Math.max(dfs(root.right), 0);

        maxSum = Math.max(maxSum, root.val + left + right);
        return root.val + Math.max(left, right);
    }
}
