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
        Map<Integer, Integer> count = new HashMap<>();
        int[] odd = new int[1];

        return dfs(root, count, odd);
    }

    private int dfs(TreeNode cur, Map<Integer, Integer> count, int[] odd) {
        if (cur == null){
            return 0;
        } 

        count.put(cur.val, count.getOrDefault(cur.val, 0) + 1);
        int odd_change = (count.get(cur.val) % 2 == 1) ? 1 : -1;
        odd[0] += odd_change;

        int res;
        if (cur.left == null && cur.right == null) {
            res = (odd[0] <= 1) ? 1 : 0;
        } 
        else{
            res = dfs(cur.left, count, odd) + dfs(cur.right, count, odd);
        }

        odd[0] -= odd_change;
        count.put(cur.val, count.get(cur.val) - 1);
        return res;
    }
}