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
    public ListNode reverseKGroup(ListNode head, int k) {
        int count = 0;
        ListNode temp = head;
        while(temp!=null){
            temp = temp.next;
            count++;
        }
        ListNode prevTail = null;
        ListNode curHead = head;
        ListNode curTail = head;
        ListNode newHead = null;
        count = count/k;
        
        while(count > 0){
            int tmp = k-1;
            while(tmp > 0){
                curTail = curTail.next;
                tmp--;
            }
            
            newHead = curTail.next;
            curTail.next = null;
            curTail = reverse(curHead);
            if(prevTail == null){
                prevTail = curHead;
                head = curTail;
            }
            else{
                prevTail.next = curTail;
                prevTail = curHead;
            }
            curHead.next = newHead;
            curHead = newHead;
            curTail = newHead;
            count--;
        }
        
        return head;
    }
    
    public ListNode reverse(ListNode head){
        ListNode curr = head;
        ListNode prev = null;
        ListNode nxt = head;
        
        while(nxt!=null){
            nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }
        
        return prev;
    }
}