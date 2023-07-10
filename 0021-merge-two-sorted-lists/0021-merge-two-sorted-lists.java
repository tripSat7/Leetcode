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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        
        if(list1 == null && list2 == null){
            return null;
        }else if(list1==null){
            return list2;
        }else if(list2==null){
            return list1;
        }
        
        ListNode temp1 = list1;
        ListNode temp2 = list2;
        ListNode resHead = new ListNode();
        
        if(temp1.val>temp2.val){
            resHead = temp2;
            temp2 = temp2.next;
        }else{
            resHead = temp1;
            temp1 = temp1.next;
        }
        ListNode temp3 = resHead;
        while(temp1!=null && temp2!=null){
            if(temp1.val > temp2.val){
                temp3.next = temp2;
                temp2= temp2.next;
                temp3 = temp3.next;
            }else{
                temp3.next = temp1;
                temp1 = temp1.next;
                temp3 = temp3.next;
            }
        }
        
        if(temp1==null){
            temp3.next = temp2;
        }else{
            temp3.next = temp1;
        }
        
        return resHead;
    }
}