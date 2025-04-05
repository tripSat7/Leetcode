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
    public TreeNode replaceValueInTree(TreeNode root) {
        map = new HashMap<>();
        map.put(0, root.val);
        
        
        helper(root, 1);
        
        map.remove(map.size() - 1);
        // System.out.println(map);
        sum(root, 0, root.val);

        return root; 
    }

    public void helper(TreeNode root, int level){
        if(root == null){
            return;
        }

        int levelSum = map.getOrDefault(level, 0);

        if(root.left != null){
            levelSum += root.left.val;
        }

        if(root.right != null){
            levelSum += root.right.val;
        }

        map.put(level, levelSum);

        helper(root.left, level + 1);
        helper(root.right, level + 1);
    }

    public void sum(TreeNode root, int level, int sib){
        if(root == null){
            return;
        }

        if(level > 1){
            root.val = map.get(level) - sib;
        }
        else{
            root.val = 0;
        }

        int sibling = 0;
        if(root.left != null){
            sibling += root.left.val;
        }

        if(root.right != null){
            sibling += root.right.val;
        }

        sum(root.left, level + 1, sibling);
        sum(root.right, level + 1, sibling);
    }
}