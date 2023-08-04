class ListNode{
    int val;
    ListNode next;
    
    ListNode(int val){
        this.val = val;
        this.next = null;
    }
}

class MyCircularQueue {

    int maxSize, size = 0;
    ListNode head = null, tail = null;
    public MyCircularQueue(int k) {
        maxSize = k;
    }
    public boolean enQueue(int val) {
        if (isFull()) return false;
        ListNode newNode = new ListNode(val);
        if (isEmpty()) head = tail = newNode;
        else {
            tail.next = newNode;
            tail = tail.next;
        }
        size++;
        return true;
    }
    public boolean deQueue() {
        if (isEmpty()) return false;
        head = head.next;
        size--;
        return true;
    }
    public int Front() {
        return isEmpty() ? -1 : head.val;
    }
    public int Rear() {
        return isEmpty() ? -1 : tail.val;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public boolean isFull() {
        return size == maxSize;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */