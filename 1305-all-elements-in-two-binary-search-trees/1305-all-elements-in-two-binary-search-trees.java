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
        
        List<Integer> res = new ArrayList<>();//to store the node data  in sorted order 
        
        Stack<TreeNode> stack1 = new Stack<>();//for tree 1
        Stack<TreeNode> stack2 = new Stack<>();//for tree 2
        
        while (!stack1.isEmpty() || root1 != null || !stack2.isEmpty() || root2 != null) //termination condition 
        {
            while (root1 != null) //pushing all left node going in depth in tree 1//Left
            {
                stack1.push(root1);
                root1 = root1.left;
            }
            while (root2 != null) //pushing all left node going in depth in tree 2//Left
            {
                stack2.push(root2);
                root2 = root2.left;
            }
            if (stack2.isEmpty() || (!stack1.isEmpty() && stack1.peek().val < stack2.peek().val&& !stack2.isEmpty()))//pushing only the smaller element which is present in stack 1//if stack 2 is not present we are dealing with stack 1
            {
                TreeNode cur1= stack1.pop();//Root
                res.add(cur1.val);//adding to the list
                root1= cur1.right;//Right
            } 
            else //just the opposite case is followed  here 
            {
                TreeNode cur2= stack2.pop();//Root
                res.add(cur2.val);//adding to the list 
                root2= cur2.right;//Right
            }
        }
        return res;
    }
}