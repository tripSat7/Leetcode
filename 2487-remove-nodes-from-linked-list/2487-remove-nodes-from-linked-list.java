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
    public ListNode removeNodes(ListNode head) {
     
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = head;
        int max= 0;
        
        while(next!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        next = prev;
        curr = prev;
        max = curr.val;
        curr = curr.next;
        while(curr!=null){
            if(curr.val>=max){
                max = curr.val;
                prev.next = curr;
                prev = curr;
            }
            curr = curr.next;
        }
        prev.next = null;
        prev = null;
        curr = next;
        while(next!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        return prev;
    }
}