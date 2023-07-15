class ListNode {
    int key;
    ListNode next;

    public ListNode(int key) {
        this.key = key;
        this.next = null;
    }
}

class MyHashSet {

    ListNode[] hashSet;
    int size;

    public MyHashSet() {
        size = 10000;
        hashSet = new ListNode[size];
    }
    
    private int hash(int key) {
        return key % size;
    }
    
    public void add(int key) {
        int index = hash(key);
        if (hashSet[index] == null) {
            hashSet[index] = new ListNode(key);
        } else {
            ListNode curr = hashSet[index];
            while (true) {
                if (curr.key == key) {
                    curr.key = key;
                    return;
                }
                if (curr.next == null) {
                    break;
                }
                curr = curr.next;
            }
            curr.next = new ListNode(key);
        }
    }
    
    public void remove(int key) {
        int index = hash(key);
        ListNode curr = hashSet[index];
        ListNode prev = null;
        while (curr != null) {
            if (curr.key == key) {
                if (prev == null) {
                    hashSet[index] = curr.next;
                } else {
                    prev.next = curr.next;
                }
                return;
            }
            prev = curr;
            curr = curr.next;
        }
    }
    
    public boolean contains(int key) {
        int index = hash(key);
        ListNode curr = hashSet[index];
        while (curr != null) {
            if (curr.key == key) {
                return true;
            }
            curr = curr.next;
        }
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */