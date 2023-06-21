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
        ListNode slow = head, fast = slow, prev, temp, next;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        prev = slow;
        slow = slow.next;
        prev.next = null;
        while(slow!=null){
            next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }
        
        temp = head;
        while(prev!=null){
            if(prev.val!=temp.val){
                return false;
            }
            prev = prev.next;
            temp = temp.next;
        }
        return true;        
    }
}