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
        HashMap<Integer, TreeNode> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        TreeNode root = new TreeNode();
        
        for(int[] row : descriptions){
            
            TreeNode parent = map.getOrDefault(row[0], new TreeNode(row[0]));
            TreeNode child = map.getOrDefault(row[1], new TreeNode(row[1]));
            
            if(row[2] == 1){
                parent.left = child;
            }
            else{
                parent.right = child;
            }
            
            set.add(row[1]);
            map.put(row[1], child);
            map.put(row[0], parent);
            
        }
        
        for(int[] row : descriptions){
            if(!set.contains(row[0])){
                return map.get(row[0]);
            }
        }
        
        return null;
    }
}