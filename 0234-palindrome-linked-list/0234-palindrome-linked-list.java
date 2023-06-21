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
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = slow;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode prev = slow;
        ListNode current = slow.next;
        ListNode next = current;
        prev.next = null;
        while(next!=null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        
        ListNode temp = head;
        while(prev!=null){
            if(prev.val!=temp.val){
                return false;
            }
            System.out.println(slow.val+"::"+prev.val);
            prev = prev.next;
            temp = temp.next;
        }
        return true;
    }
}