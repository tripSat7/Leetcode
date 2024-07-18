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
    int count;
    public int countPairs(TreeNode root, int distance) {
        count = 0;
        dfs(root, distance);
        return count;
    }

    public List<Integer> dfs(TreeNode root, int d) {
        if (root == null) {
            return new ArrayList<>();
        }

        if (root.left == null && root.right == null) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            return list;
        }

        List<Integer> l = dfs(root.left, d);
        List<Integer> r = dfs(root.right, d);

        for (int i: l) {
            for (int j: r) {
                if (i + j <= d) {
                    count++;
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i: l) {
            if (i + 1 < d) {
                result.add(i + 1);
            }
        }
        for (int i: r) {
            if (i + 1 < d) {
                result.add(i + 1);
            }
        }
        return result;
    }
}