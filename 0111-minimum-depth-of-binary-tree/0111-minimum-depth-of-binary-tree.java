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
    public int minDepth(TreeNode root) {
       
        if(root == null){
            return 0;
        }
        
        int lh = minDepth(root.left);
        int rh = minDepth(root.right);
        
        int minH;
        
        if(lh == 0){
            minH = rh;
        }
        else if(rh == 0){
            minH = lh;
        }
        else{
            minH = lh>rh?rh:lh;
        }
        
        return 1+minH;
    }
    
//     public int helper(TreeNode root){
        
//         if(root == null){
//             return 0;
//         }
        
//         int ld = minDepth(root.left);
//         int rd = minDepth(root.right);
        
//         return ld>rd? 1+ld : 1+rd;
//     }
}