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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode temp1 = head, temp2 = head;
        int count = 1, c1=1;
        while(temp1!=null){
            count++;
            temp1 = temp1.next;
            if(count==k){
                temp2 = temp1;
            }
        }
        System.out.println(count);
        temp1 = head;
        while(c1<(count-k)){
            if(c1<k){
                temp1 = temp1.next;
            }else{
                temp2 = temp2.next;
            }
            c1++;
        }
        System.out.println(temp1.val+":"+temp2.val);
        int swap = temp1.val;
        temp1.val = temp2.val;
        temp2.val = swap;
        
        return head;
    }
}