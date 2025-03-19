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
    public String smallestFromLeaf(TreeNode root) {
        // StringBuilder left = new StringBuilder(helper(root, ""));
        // StringBuilder right = new StringBuilder(helper(root, ""));

        return helper(root, "");
    }

    public String helper(TreeNode root, String st){

        if(root == null){
            return "*";
        }

        char ch = (char)('a' + root.val);

        if(root.left == null && root.right == null){
            return ""+ ch + st;
        }
        
       
        
        String lst = helper(root.left, ""+ ch + st);
        String rst = helper(root.right, ""+ ch + st);
        System.out.println(lst + "||" + rst);

        if(lst.equals("*")){
            return rst;
        }
        else if(rst.equals("*")){
            return lst;
        }

        int t = lst.compareTo(rst);
        return t > 0 ? rst : lst;

    }
}