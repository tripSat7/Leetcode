/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        /*HashMap<Node,Node> map = new HashMap<>();
        Node copyHead = new Node(head.val);
        copyHead.next = head.next;
        map.put(head,copyHead);
        Node trav = copyHead.next;
        
        while(trav!=null){
            Node temp = new Node(trav.val);
            temp.next = trav.next;
            map.put(trav,temp);
            trav = trav.next;
        }
        
        trav = head;
        
        while(trav!=null){
            map.get(trav).random = map.get(trav.random);
            trav = trav.next;
        }
        
        return copyHead;*/
        
        Node cur = head;
        HashMap<Node, Node> map = new HashMap<>();
        while (cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }
}