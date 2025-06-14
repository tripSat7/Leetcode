class LRUCache {

    class Node{
        int key;
        int val;
        Node next, prev;

        Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }

    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);
    HashMap<Integer, Node> map = new HashMap<>();
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }

        Node remNode = map.get(key);
        int res = remNode.val;
        map.remove(key);
        remove(remNode);

        addNode(remNode);
        map.put(key, remNode);

        return res;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node remNode = map.get(key);
            remove(remNode);
            map.remove(key);
        }

        if(map.size() == capacity){
            map.remove(tail.prev.key);
            remove(tail.prev);
        }

        Node newNode = new Node(key, value);
        addNode(newNode);
        map.put(key, newNode);
    }

    public void addNode(Node newNode){
        Node temp = newNode;

        temp.prev = head;
        temp.next = head.next;

        temp.next.prev = temp;

        head.next = temp;
    }

    public void remove(Node remNode){
        Node prevNode = remNode.prev;
        Node nextNode = remNode.next;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */