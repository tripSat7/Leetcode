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
    public ListNode partition(ListNode head, int x) {
        
        if(head == null || head.next == null){
            return head;
        }
        
        ListNode less = null;
        ListNode great = null;
        ListNode temp = head;
        ListNode gHead = null;
        ListNode lHead = null;
        
        while(temp!=null){
            if(temp.val < x){
                if(less == null){
                    lHead = temp;
                    less = lHead;
                }
                else{
                    less.next  = temp;
                    less = less.next;
                }
            }
            else{
                if(great == null){
                    gHead = temp;
                    great = gHead;
                }
                else{
                    great.next  = temp;
                    great = great.next;
                }
            }
            
            temp = temp.next;
        }
        
        if(less == null){
            return gHead;
        }
        else if(gHead == null){
            return lHead;
        }
        else{
            less.next = gHead;
            great.next = null;    
        }
        
        return lHead;
    }
}