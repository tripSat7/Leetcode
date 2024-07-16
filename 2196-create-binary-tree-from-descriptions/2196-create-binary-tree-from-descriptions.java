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
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer,TreeNode> map= new HashMap<>();
        for(int[] row : descriptions){
            map.put(row[1],new TreeNode(row[1]));
        }
        
        TreeNode root=null;
        for(int[]row : descriptions){
            if(!map.containsKey(row[0])){
                root= new TreeNode(row[0]);
                map.put(row[0],root);
            }
            
            if(row[2] == 1){
                map.get(row[0]).left = map.get(row[1]);
            }
            else{
                map.get(row[0]).right = map.get(row[1]);
            }
        }
        return root;
    }
}