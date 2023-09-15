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
    public void flatten(TreeNode root) {
        if(root == null){
            return;
        }
        
        while(root!=null){
            if(root.left != null){
                TreeNode tempLeft = root.left;
                TreeNode cur = tempLeft;
                while(cur.right != null){
                    cur = cur.right;
                }
                cur.right = root.right;
                root.left = null;
                root.right = tempLeft;
                
            }
            root = root.right;
        }
    }
    
}