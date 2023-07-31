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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next==null){
            return head;
        }
        ListNode last = head;
        int count = 1;
        
        while(last.next!=null){
            count++;
            last = last.next;
        }
        
        last.next = head;
        ListNode temp = head;
        count = count-(k%count);
        while(count>0){
            temp = temp.next;
            count--;
        }
        head = temp;
        
        while(temp.next!=head){
            temp = temp.next;
        }
        temp.next = null;
        
        return head;
    }
}