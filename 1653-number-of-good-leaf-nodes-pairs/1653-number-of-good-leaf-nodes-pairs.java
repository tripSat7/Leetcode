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
    int count = 0;
    public int countPairs(TreeNode root, int distance) {
        
        dfs(root, distance);
        return count;
    }
    
    public List<Integer> dfs(TreeNode root, int distance){
        
        if(root == null){
            return new ArrayList<>();
        }
        
        if(root.left == null && root.right == null){
            List<Integer> dist = new ArrayList<>();
            dist.add(1);
            return dist;
        }
        
        List<Integer> leftDist = dfs(root.left, distance);
        List<Integer> rightDist = dfs(root.right, distance);
        
        for(int i : leftDist){
            for(int j : rightDist){
                if(i+j <= distance){
                    count++;
                }
            }
        }
        
        List<Integer> list = new ArrayList<>();
        for(int i : leftDist){
            if(i+1 < distance){
                list.add(i+1);
            }
            
        }
            
        for(int i : rightDist){
            if(i+1 < distance){
                list.add(i+1);
            }
        }
            
        return list;
    }
}