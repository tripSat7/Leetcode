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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        
        List<TreeNode> list1 = new ArrayList<>(); 
        List<TreeNode> list2 = new ArrayList<>(); 
        
        inOrderTraversal(list1,root1);
        inOrderTraversal(list2,root2);
        int size1 = list1.size();
        int size2 = list2.size();
        List<Integer> res = new ArrayList<>();
        int n = size1>size2 ? size2 : size1;
        
        int i=0, j=0;
        while(i<size1 || j<size2){
            if(i<size1 && j<size2 && list1.get(i).val > list2.get(j).val){
                res.add(list2.get(j).val);
                j++;
            }
            else if (i<size1 && j<size2 && list1.get(i).val <= list2.get(j).val){
                res.add(list1.get(i).val);
                i++;
            }
            else{
                if(i>=size1){
                    while(j<size2){
                        res.add(list2.get(j).val);
                        j++;
                    }
                }
                else{
                    while(i<size1){
                        res.add(list1.get(i).val);
                        i++;
                    }
                }
            }
        }
        

        return res;
    }
    
    public void inOrderTraversal(List<TreeNode> inorder, TreeNode root){
        if(root == null){
            return;
        }
        
        inOrderTraversal(inorder, root.left);
        inorder.add(root);
        inOrderTraversal(inorder, root.right);
    }
}