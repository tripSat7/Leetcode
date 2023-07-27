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
    public void reorderList(ListNode head) {
        
        ListNode slow = head, fast = head;
        
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        fast = slow;
        ListNode prev = null;
        
        while(fast!=null){
            fast = fast.next;
            slow.next = prev;
            prev = slow;
            slow = fast;
        }
        
        slow = head;
        fast = head.next;
        ListNode prevNext = prev.next;
        
        while(prevNext!=null){
            slow.next = prev;
            prev.next = fast;
            slow = fast;
            fast = fast.next;
            prev = prevNext;
            prevNext = prevNext.next;
        }
        
    }
}