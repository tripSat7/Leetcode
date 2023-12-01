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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        int lvl = 0;
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
                List<Integer> copy = new ArrayList<>(curr);
                curr.clear();
                if(lvl % 2 == 0){
                    res.add(copy);    
                }
                else{
                    Collections.reverse(copy);
                    res.add(copy);
                }
                lvl++;
                
                if(!q.isEmpty()){
                    q.add(null);
                }
            }
        }
        
        return res;
    }
}