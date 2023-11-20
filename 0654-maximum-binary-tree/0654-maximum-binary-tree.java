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
    TreeNode Tree_making(int start,int end,int[]nums){
        if(start>end){
            return null;
        }
        int index=start;
        for(int i=start;i<=end;i++){
            if(nums[index]<nums[i]){
                index=i;
            }
        }
        TreeNode root=new TreeNode(nums[index]);
        root.left=Tree_making(start,index-1,nums);
        root.right=Tree_making(index+1,end,nums);
        return root;
    }
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        
       return Tree_making(0,nums.length-1,nums);

    }
}