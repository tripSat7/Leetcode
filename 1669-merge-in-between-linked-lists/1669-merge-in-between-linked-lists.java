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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode temp1 = list1;
        ListNode prev = null;
        ListNode temp2 = list2;
        
        while(temp2.next!=null){
            temp2 = temp2.next;
        }
        
        int c1=0, c2=a;
        
        while(c2<=b){
            if(c1<a){
                c1++;
                prev=temp1;
            }
            else{
                c2++;
            }
            temp1=temp1.next;
        }
        
        prev.next = list2;
        temp2.next = temp1;
        
        return list1;
    }
}