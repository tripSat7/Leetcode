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
    List<List<Integer>> res;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        
        res = new ArrayList<>();

        helper(root, targetSum, new ArrayList<>());
        return res;
    }

    public void helper(TreeNode root, int targetSum, List<Integer> list) {
        
        if(root == null){
            return;
        }
        
        if(targetSum - root.val == 0 && (root.left == null && root.right == null)){
            
            list.add(root.val);
            res.add(new ArrayList<>(list));
            // System.out.println("Res == "+list);
            list.remove(list.size() - 1);
            return;
        }
        
        list.add(root.val);
        // System.out.println(list);
        helper(root.left, targetSum - root.val, list);
        helper(root.right, targetSum - root.val, list);
        list.remove(list.size() - 1);

    }
}