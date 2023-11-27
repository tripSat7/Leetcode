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
    public List<Integer> rightSideView(TreeNode root) {
        
        if(root == null){
            return new ArrayList<>();
        }
        
        Queue<TreeNode> level = new LinkedList<>();
        level.add(root);
        level.add(null);
        
        List<Integer> curr = new ArrayList<>();
        List<List<Integer>> nodes = new ArrayList<>();

        
        while(!level.isEmpty()){
            TreeNode temp = level.poll();
            if(temp!=null){
                curr.add(temp.val);
                if(temp.left != null){
                    level.add(temp.left);
                }
                if(temp.right != null){
                    level.add(temp.right);
                }
            }
            else{
                List<Integer> copy = new ArrayList<>(curr);
                curr.clear();
                nodes.add(copy);
                
                if(!level.isEmpty()){
                    level.add(null);
                }
            }
        }
        
        curr.clear();
        for(List<Integer> list : nodes){
            int size = list.size();
            curr.add(list.get(size-1));
        }
        
        return curr;
    }
}