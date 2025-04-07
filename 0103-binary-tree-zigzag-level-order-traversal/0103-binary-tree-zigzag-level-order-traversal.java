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
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null){
            return res;
        } 

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()) {
            int size = q.size();
            Integer[] level = new Integer[size];
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                int idx = (res.size() % 2 == 0) ? i : size - i - 1;
                level[idx] = node.val;
                if(node.left != null){
                    q.offer(node.left);
                } 
                if(node.right != null){
                    q.offer(node.right);
                } 
            }
            res.add(Arrays.asList(level));
        }
        return res;
    }
}