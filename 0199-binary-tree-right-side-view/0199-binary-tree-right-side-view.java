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
    List<Integer> res = new ArrayList<>();
    int max = 0;
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null){
            return res;
        }
        
        helper(root, 1);
        
        return res;
    }
    
    public void helper(TreeNode root, int level){
        if(root == null){
            return;
        }
        
        if(level > max){
            res.add(root.val);
            max++;
        }
        helper(root.right, level+1);
        helper(root.left, level+1);
    }
}