/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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

    public boolean isSubPath(ListNode head, TreeNode root) {
        if (root == null){
            return false;
        } 
        return checkPath(root, head);
    }

    private boolean checkPath(TreeNode node, ListNode head) {
        if(node == null){
            return false;
        } 
        if(dfs(node, head)){
            return true;
        }  
        return checkPath(node.left, head) || checkPath(node.right, head);
    }

    private boolean dfs(TreeNode node, ListNode head) {
        if (head == null){
            return true;
        } 
        if (node == null){
            return false;
        }  
        if (node.val != head.val){
            return false;
        }
        return dfs(node.left, head.next) || dfs(node.right, head.next);
    }
}