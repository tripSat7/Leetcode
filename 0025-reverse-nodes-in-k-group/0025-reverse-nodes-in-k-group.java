// Time Complexity: O(N) - Each node is visited a constant number of times (counting, splitting, and reversing).
// Space Complexity: O(1)

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
    public ListNode reverseKGroup(ListNode head, int k) {
        int count = 0;
        ListNode temp = head;
        // Count total number of nodes
        while (temp != null) {
            temp = temp.next;
            count++;
        }

        ListNode prevTail = null;    // End of the previous reversed block
        ListNode curHead = head;     // Start of the current block
        ListNode curTail = head;     // End of the current block
        ListNode newHead = null;     // Next node after current block
        count = count / k;           // Number of full k-groups to reverse

        // Process each k-group
        while (count > 0) {
            int tmp = k - 1;
            // Move curTail to end of current k-group
            while (tmp > 0) {
                curTail = curTail.next;
                tmp--;
            }

            newHead = curTail.next;    // Save next group start
            curTail.next = null;       // Cut the current group
            curTail = reverse(curHead);// Reverse the current group

            if (prevTail == null) {
                // For first block, update head
                prevTail = curHead;
                head = curTail;
            } else {
                // Connect previous block to current reversed head
                prevTail.next = curTail;
                prevTail = curHead;
            }

            curHead.next = newHead;    // Connect reversed group to the next block
            curHead = newHead;         // Move to the next group
            curTail = newHead;
            count--;
        }

        return head;
    }

    // Reverse the given linked list and return new head
    public ListNode reverse(ListNode head) {
        ListNode curr = head, prev = null, nxt = head;
        while (nxt != null) {
            nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }
        return prev;
    }
}
