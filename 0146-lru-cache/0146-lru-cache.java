// Time Complexity: O(1) for both get and put operations (amortized)
// Space Complexity: O(capacity) for the hashmap and linked list nodes

class LRUCache {

    // Doubly-linked list node
    class Node {
        int key, val;
        Node prev, next;
        Node(int k, int v){ 
            key = k; 
            val = v; 
        }
    }

    private int capacity;
    private Map<Integer, Node> map = new HashMap<>();
    private Node head = new Node(-1, -1);  // Dummy head
    private Node tail = new Node(-1, -1);  // Dummy tail

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        // If not present, return -1
        if (!map.containsKey(key)) return -1;

        // Move accessed node to front (most recently used)
        Node node = map.get(key);
        remove(node);
        addToFront(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        // If key exists, remove old node
        if (map.containsKey(key)) {
            Node old = map.get(key);
            remove(old);
            map.remove(key);
        }
        // If at capacity, evict least recently used (tail.prev)
        if (map.size() == capacity) {
            Node lru = tail.prev;
            remove(lru);
            map.remove(lru.key);
        }
        // Insert new node at front
        Node node = new Node(key, value);
        addToFront(node);
        map.put(key, node);
    }

    // Helper: add node right after head
    private void addToFront(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    // Helper: unlink node from list
    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */