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
    public int getDecimalValue(ListNode head) {
        ListNode temp = head;
        int res=0, count=0;
        while(temp!=null){
            count++;
            temp=temp.next;
        }
        count--;
        temp = head;
        while(temp!=null){
            
            if(temp.val==1){
                System.out.println(count+":"+temp.val+"::"+Math.pow(2,count));
                res = res+(int)Math.pow(2,count);
            }
            count--;
            temp=temp.next;
        }
        
        return res;
    }
}