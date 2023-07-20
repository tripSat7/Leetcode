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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        
        ListNode ans = new ListNode();
        ListNode res = ans;
        int carry = 0, sum = 0;
        while(temp1!=null || temp2!=null){
            
            if(temp1!=null){
                sum+= temp1.val;
                temp1 = temp1.next;
            }
            
            if(temp2!=null){
                sum+= temp2.val;
                temp2 = temp2.next;
            }
            
            ans.val = sum%10;
            carry = sum/10;
            
            if(temp1!=null || temp2!=null){
                ListNode temp = new ListNode(carry);
                ans.next = temp;
                ans = temp;
            }else if(carry>0){
                ListNode temp = new ListNode(carry);
                ans.next = temp;
                ans = temp;
            }
            sum = carry;
        }
        
        return res;
    }
}