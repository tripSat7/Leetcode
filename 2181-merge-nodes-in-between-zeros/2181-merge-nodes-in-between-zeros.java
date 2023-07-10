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
            resTemp.next = temp;
            resTemp = resTemp.next;
            resTemp.val = sum;
            
            temp = temp.next;
        }
        
        return res.next;
    }
}