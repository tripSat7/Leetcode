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
    private int currentLevel = 0;
    private int leftNodeValue = 0;
    
    public int findBottomLeftValue(TreeNode root) {
        findBottomLeft(root, 1);
        return leftNodeValue;
    }
    
    private void findBottomLeft(TreeNode node, int level){
        if(node == null) return;
        
        if(currentLevel < level){
            currentLevel = level;
            leftNodeValue = node.val;
        }       
        
        findBottomLeft(node.left, level+1);
        findBottomLeft(node.right, level+1);        
    }
}