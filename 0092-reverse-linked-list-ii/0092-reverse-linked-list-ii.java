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
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head.next==null || left==right){
            return head;
        }
        int count = 1;
        ListNode leftNode = null, temp = head, prev = null, next = null;
        left--;
        while(right>0){
            if(left>0){
                leftNode = temp;
                temp = temp.next;
                left--;
            }else{
                next = temp.next;
                temp.next = prev;
                prev = temp;
                temp = next;
            }
            right--;
        }
        if(leftNode!=null){
            leftNode.next.next = temp;
            leftNode.next = prev;    
        }else{
            head.next = temp;
            head = prev;
        }
        
        
        return head;
    }
}