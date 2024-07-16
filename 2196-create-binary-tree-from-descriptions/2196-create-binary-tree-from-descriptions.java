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
        HashMap<Integer, TreeNode> hm = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        TreeNode root = new TreeNode();
        
        for(int[] a : descriptions){
            
            Integer parent = a[0];
            Integer child = a[1];
            Integer isLeft = a[2];

            if(!hm.containsKey(parent)){
                TreeNode parentNode = new TreeNode(parent);
                hm.put(parent,parentNode);
            }
            if(hm.containsKey(child)){
                TreeNode childNode = hm.get(child);
                TreeNode parentNode = hm.get(parent);
                if(isLeft==1){
                    parentNode.left = childNode;
                }
                else{
                    parentNode.right = childNode;
                }
            }else{
                TreeNode childNode = new TreeNode(child);
                hm.put(child,childNode);

                TreeNode parentNode = hm.get(parent);
               if(isLeft==1){
                    parentNode.left = childNode;
                }
                else{
                    parentNode.right = childNode;
                }
            }
            set.add(a[1]);
            
        }
        
        for(int[] row : descriptions){
            if(!set.contains(row[0])){
                return hm.get(row[0]);
            }
        }
        
        return null;
    }
}