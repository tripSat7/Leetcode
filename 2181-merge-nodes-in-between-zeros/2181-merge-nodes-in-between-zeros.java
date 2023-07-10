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
    public ListNode mergeNodes(ListNode head) {
        ListNode res = head;
        ListNode temp = head.next;
        ListNode resTemp = res;
        while(temp!=null){
            int sum=0;
            while(temp.val!=0){
                sum+=temp.val;
                temp=temp.next;
            }
            resTemp.val = sum;
            if(temp.next==null){
                resTemp.next = null;
            }
            else{
                resTemp.next = temp;
                resTemp = resTemp.next;
            }
            temp = temp.next;
        }
        
        return res;
    }
}