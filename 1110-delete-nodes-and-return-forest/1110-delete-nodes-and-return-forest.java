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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> res = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        
        for(int i : to_delete){
            set.add(i);
        }
        
        root = dfs(root, set, res);
        if(root!= null){
            res.add(root);
        }
        
        return res;
    }
    
    public TreeNode dfs(TreeNode root, Set<Integer> set, List<TreeNode> res){
        if(root == null){
            return null;
        }
        // System.out.println(root.val);
        root.left = dfs(root.left, set, res);
        
        root.right = dfs(root.right, set, res);
        
        if(set.contains(root.val)){
            TreeNode left = root.left;
            TreeNode right = root.right;
            
            if(left != null){
                res.add(left);
            }
            
            if(right != null){
                res.add(right);
            }
            
            root = null;
        }
        
        return root;
    }
}