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
    public ListNode[] splitListToParts(ListNode head, int k) {
        
        ListNode res[] = new ListNode[k];
        
        int i = 0, count = 0;
        ListNode temp = head;
        while(temp!=null){
            count++;
            temp = temp.next;
        }
        
        temp = head;
        
        int def, ex = 0;
        boolean split;
        
        if(count<k){
            def = 1;
            split = true;
        }else{
            def = (count/k);
            split = false;
            ex = count%k;
        }
        
        while(i<k && temp!=null){
            int size;
            if(split){
                size = 1;
            }
            else{
                if(ex>0){
                    size = def + 1;    
                    ex--;    
                }else{
                    size = def;
                }   
            }
             
            int ptr = 0;
            res[i] = temp;
            ListNode prev = null;
            while(ptr<size){
                prev = temp;
                temp = temp.next;
                ptr++;
            }
                
            if(temp!=null){
                prev.next = null;
            }
            i++;
        }
        
        return res;
    }
}