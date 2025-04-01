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
    HashMap<Long, Integer> map;
    public int pathSum(TreeNode root, int targetSum) {
        map = new HashMap<>();
        map.put(0L, 1);
        return helper(root, targetSum, 0);
    }

    public int helper(TreeNode root, int k, long sum){

        if(root == null){
            return 0;
        }

        sum += root.val;
        int count = map.getOrDefault(sum - k, 0);

        map.put(sum, map.getOrDefault(sum, 0) + 1);
        count += helper(root.left, k, sum);
        count += helper(root.right, k, sum);   

        map.put(sum, map.get(sum) - 1);
        if(map.get(sum) == 0){
            map.remove(sum);
        }

        return count;
    }
}