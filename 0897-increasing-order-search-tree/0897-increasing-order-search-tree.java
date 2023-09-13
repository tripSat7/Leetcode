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
    public TreeNode increasingBST(TreeNode root) {
        
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);
        TreeNode res = new TreeNode(-1), itr = res;
        for(int i : list){
            itr.right = new TreeNode(i);
            itr = itr.right;
        }
        
        return res.right;
    }
    
    public void inOrder(TreeNode root, List<Integer> list){
        if(root == null){
            return;
        }
        
        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }
}