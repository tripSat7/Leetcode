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
        ListNode head;
        int length;

        public Solution(ListNode head) {
            this.head = head;
            ListNode temp = head;
            while (temp != null){
                temp = temp.next;
                length++;
            }
        }

        public int getRandom() {
            double random = Math.random();
            random = Math.floor(random * length);
            ListNode temp = head;
            while (random > 0){
                temp = temp.next;
                random--;
            }
            return temp.val;
        }
    }



/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */