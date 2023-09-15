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
    int sum = 0;
    public int sumRootToLeaf(TreeNode root) {
        
        helper(root,"");
        
        return sum;
    }
    
    public void helper(TreeNode root, String s){
        if(root == null){
            return;
        }
        String lev = s + "" + root.val;
        if(root.left == null && root.right == null){
            sum = sum + stringToInt(lev);
        }
        
        helper(root.left, lev);
        helper(root.right, lev);
    }
    
    public int stringToInt(String str){
        double bin = Math.pow(2,(str.length()-1));
        double res = 0;
        for(char c : str.toCharArray()){
            if(c == '1'){
                res = res + bin;
            }
            bin = bin/2;
        }
        return (int) res;
    }
}