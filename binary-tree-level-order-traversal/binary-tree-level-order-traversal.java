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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        
        if(root == null){
            return res;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        ArrayList<Integer> curr = new ArrayList<>();
        while(!q.isEmpty()){
            TreeNode tmp = q.remove();
            if(tmp!=null){
                curr.add(tmp.val);
                if(tmp.left != null){
                    q.add(tmp.left);
                }
                if(tmp.right != null){
                    q.add(tmp.right);
                }
            }
            else{
                ArrayList<Integer> copy = new ArrayList<>(curr);
                curr.clear();
                res.add(copy);
                if(!q.isEmpty()){
                    q.add(null);
                }
            }
        }
        
        return res;
    }
}