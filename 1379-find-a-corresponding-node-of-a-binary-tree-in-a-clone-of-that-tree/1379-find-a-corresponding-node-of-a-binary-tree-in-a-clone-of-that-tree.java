/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    
    TreeNode target, res;
    public void inOrder(TreeNode original, TreeNode cloned){
        if(original!=null){
            if(original == target){
                res = cloned;
            }
            inOrder(original.left, cloned.left);
            inOrder(original.right, cloned.right);

        }
        
    }
    
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        
        this.target = target;
        inOrder(original, cloned);
        return res;
    }
}