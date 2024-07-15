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
    
    HashMap<Integer, Integer> map;
    int height = 0;
    public List<Integer> largestValues(TreeNode root) {
        
        map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        
        large(root, 0);
        for(int i = 0; i < height; i++){
            res.add(map.get(i));            
        }
        
        return res;
    }
    
    public void large(TreeNode root, int level){
        
        if(root == null){
            height = Math.max(height,level);
            return;
        }
        
        large(root.left, level + 1);
        large(root.right, level + 1);
        
        if(!map.containsKey(level)){
            map.put(level, root.val);
        }
        else{
            if(root.val > map.get(level)){
                map.put(level, root.val);
            }    
        }
        
    }
}