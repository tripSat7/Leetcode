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
    public List<Double> averageOfLevels(TreeNode root) {
        
        if(root==null)
        {
            return List.of();
        }
        
        List<Double> res = new ArrayList<>();
        
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        q.add(null);
        double sum = 0;
        int lc = 0;

        while(!q.isEmpty()){
            TreeNode temp = q.remove();
            
            if(temp!=null){
                sum += (double)temp.val;
                lc++;
                if(temp.left != null){
                    q.add(temp.left);
                }
                if(temp.right != null){
                    q.add(temp.right);
                }
            }
            else{                
                res.add((sum)/lc);
                sum = 0;
                lc = 0;
                if(!q.isEmpty()){
                    q.add(null);
                }
            }
        }
        
        return res;
    }
}