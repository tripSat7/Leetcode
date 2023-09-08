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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        
        if(head.next == null){
            return head;
        }
        
        ListNode res = head;
        ListNode fast = head;
        ListNode prev = null;
        
        while(fast.next!=null && fast!=null){
            prev = fast;
            fast = fast.next;
            System.out.println(prev.val);
            ListNode tmp = new ListNode(gcd(prev.val,fast.val));
            prev.next = tmp;
            tmp.next = fast;
        }
        
        return res;
    }
    
    public int gcd(int a, int b) {
        if (b==0) return a;
        return gcd(b,a%b);
    }
}