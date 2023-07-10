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
        int sum=0;
        while(temp!=null){
            if(temp.val!=0){
                sum+=temp.val;
            }else{
                if(temp.next==null){
                    resTemp.val = sum;
                    resTemp.next = null;
                }else{
                    resTemp.val = sum;
                    resTemp.next = temp;
                    resTemp = resTemp.next;
                    sum=0;
                }
            }
            temp=temp.next;
        }
        
        return res;
    }
}