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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        System.out.println(root.val +"||"+ p.val+"||"+ q.val);
        if(q.val < p.val){
            return lowestCommonAncestor(root, q, p);
        }

        
        if(root.val > p.val && root.val < q.val){
            return root;
        }

        if(p.val == root.val){
            return p;
        }

        if(q.val == root.val){
            return q;
        }

        if(p.val < root.val){
            return helper(root.left, p, q);
        }
        else{
            return helper(root.right, p, q);
        }

    }

    public TreeNode helper(TreeNode root, TreeNode p, TreeNode q){
        System.out.println(root.val);
        if(root.val > p.val && root.val < q.val){
            return root;
        }

        if(p.val == root.val){
            return p;
        }

        if(q.val == root.val){
            return q;
        }

        if(p.val < root.val){
            return helper(root.left, p, q);
        }
        else{
            return helper(root.right, p, q);
        }
    }
}