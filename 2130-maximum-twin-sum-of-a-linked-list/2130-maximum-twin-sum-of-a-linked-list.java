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
    public int pairSum(ListNode head) {
        if(head.next.next == null){
            return head.val+head.next.val;
        }
        
        int max=0;
        ListNode slow = head, fast = head;
        
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode next = slow;
        fast = null;
        
        while(next!=null){
            next = slow.next;
            slow.next = fast;
            fast = slow;
            slow = next;
        }
        slow = head;
        while(fast!=null){
            if(slow.val+fast.val>max){
                max = slow.val+fast.val;
            }
            slow = slow.next;
            fast = fast.next;
        }
        
        return max;
    }
}