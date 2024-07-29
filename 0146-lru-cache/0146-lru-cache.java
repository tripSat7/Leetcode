class LRUCache {

    class Node{
        int key, val;
        Node prev, next;
        
        Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }
    
    HashMap<Integer, Node> map = new HashMap<>();
    Node head = new Node(-1,-1);
    Node tail = new Node(-1,-1);
    int cap;
    
    public LRUCache(int capacity) {
        cap = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        // System.out.println(map);
        if(map.containsKey(key)){
            Node remNode = map.get(key);
            int res = remNode.val;
            
            map.remove(key);
            remove(remNode);
            addNode(remNode);
            map.put(key,head.next);
            
            return res;
        }
        
        
        return -1;
    }
    
    public void put(int key, int value) {
        
        if(map.containsKey(key)){
            Node remNode = map.get(key);
            map.remove(key);
            remove(remNode);
        }
        
        if(map.size() == cap){
            map.remove(tail.prev.key);
            remove(tail.prev);
        }
        
        addNode(new Node(key,value));
        map.put(key,head.next);
        // System.out.println(map);
    }
    
    public void remove(Node delNode){
        Node prevDel = delNode.prev;
        Node nextDel = delNode.next;
        
        prevDel.next = nextDel;
        nextDel.prev = prevDel;
    }
    
    private void addNode(Node newnode) {
        Node temp = head.next;

        newnode.next = temp;
        newnode.prev = head;

        head.next = newnode;
        temp.prev = newnode;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */