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

class Pair{
    TreeNode node;
    int idx;
    
    Pair(TreeNode node, int idx){
        this.node = node;
        this.idx = idx;
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root,0));
        
        int max = 0;
        while(!q.isEmpty()){
            int size = q.size();   
            int start = 0, end = 0;
            
            for(int i = 0; i<size; i++){
                Pair node = q.remove();
                int idx = node.idx;
                if(i==0){
                    start = idx;
                }
                if(i==size-1){
                    end = idx;
                }
                
                if(node.node.left != null){
                    q.add(new Pair(node.node.left, 2*idx));
                }
                
                if(node.node.right!=null){
                    q.add(new Pair(node.node.right, 2*idx + 1));
                }
            }
            max = Math.max(max, end - start + 1);
        }
        
        return max;
    }
}