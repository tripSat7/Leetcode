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
    int count = 0;
    public int averageOfSubtree(TreeNode root) {
     
        getSum(root);
        return count;
    }
    
    public int[] getSum(TreeNode root){
        if(root == null){
            return new int[]{0,0};
        }
        int []ls = getSum(root.left);
        int []rs = getSum(root.right);
        
        int sum = ls[0] + rs[0] + root.val;
        int n = ls[1] + rs[1] + 1;
        if((sum/n) == root.val){
            count++;
        }
        
        return new int[]{sum, n};
    }
    
}