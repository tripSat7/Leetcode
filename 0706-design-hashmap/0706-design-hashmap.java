class ListNode {
    int key;
    int value;
    ListNode next;

    public ListNode(int key, int value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }
}

class MyHashMap {
    ListNode[] hashmap;
    int size;

    public MyHashMap() {
        size = 10000;
        hashmap = new ListNode[size];
    }

    private int hash(int key) {
        return key % size;
    }

    public void put(int key, int value) {
        int index = hash(key);
        if (hashmap[index] == null) {
            hashmap[index] = new ListNode(key, value);
        } else {
            ListNode curr = hashmap[index];
            while (true) {
                if (curr.key == key) {
                    curr.value = value;
                    return;
                }
                if (curr.next == null) {
                    break;
                }
                curr = curr.next;
            }
            curr.next = new ListNode(key, value);
        }
    }

    public int get(int key) {
        int index = hash(key);
        ListNode curr = hashmap[index];
        while (curr != null) {
            if (curr.key == key) {
                return curr.value;
            }
            curr = curr.next;
        }
        return -1;
    }

    public void remove(int key) {
        int index = hash(key);
        ListNode curr = hashmap[index];
        ListNode prev = null;
        while (curr != null) {
            if (curr.key == key) {
                if (prev == null) {
                    hashmap[index] = curr.next;
                } else {
                    prev.next = curr.next;
                }
                return;
            }
            prev = curr;
            curr = curr.next;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */