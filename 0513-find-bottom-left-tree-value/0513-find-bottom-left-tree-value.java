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
    public int findBottomLeftValue(TreeNode root) {
        
        int res = 0;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        
        List<Integer> curr = new ArrayList<>();
        
        while(!q.isEmpty()){
            TreeNode temp = q.poll();
            if(temp!=null){
                curr.add(temp.val);
                if(temp.left!=null){
                    q.add(temp.left);
                }
                
                if(temp.right!=null){
                    q.add(temp.right);
                }
            }
            else{
                res = curr.get(0);
                curr.clear();
                if(!q.isEmpty()){
                    q.add(null);
                }
            }
        }
        
        return res;
    }
}