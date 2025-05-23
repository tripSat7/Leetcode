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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        
        if(root == null) return res;
    
        queue.add(root);
        while(!queue.isEmpty()){
            int n = queue.size();
            List<Integer> tuple = new ArrayList<>();
            for(int i=0; i<n; i++){
                TreeNode node = queue.removeFirst();
                tuple.add(node.val);

                if(node.left != null){
                    queue.addLast(node.left);
                }

                if(node.right != null){
                    queue.addLast(node.right);
                }
            }
            res.add(tuple);
        }
        return res;
    }
}