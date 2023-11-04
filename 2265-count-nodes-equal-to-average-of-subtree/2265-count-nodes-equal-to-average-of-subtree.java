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
    
    public int getSum(TreeNode root){
        if(root == null){
            return 0;
        }
        int ls = getSum(root.left);
        int rs = getSum(root.right);
        
        int sum = ls + rs + root.val;
        int n = getCount(root);
        //System.out.println(sum+"||"+n+"||"+root.val);
        if((sum/n) == root.val){
            count++;
        }
        
        return sum;
    }
    
    public int getCount(TreeNode root){
        if(root == null){
            return 0;
        }
        int lc = getCount(root.left);
        int rc = getCount(root.right);
        
        int total = lc + rc + 1;
        
        return total;
    }
}