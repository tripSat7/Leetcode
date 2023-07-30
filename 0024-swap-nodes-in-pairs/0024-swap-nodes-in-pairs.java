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
    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode slow = head, fast = head.next, prev = null;
        head = fast;
        while(fast!=null){
            slow.next = fast.next;
            fast.next = slow;
            if(prev!=null){
                prev.next = fast;
            }
            prev = slow;
            slow = fast;
            fast = prev;
            if(fast.next==null){
                break;
            }
            slow = slow.next.next;
            fast = fast.next.next;
        }
        
        return head;
    }
}