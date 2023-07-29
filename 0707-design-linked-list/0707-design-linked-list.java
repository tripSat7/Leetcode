class Node{
    int val;
    Node next;

    Node(int val){
        this.val = val;
        this.next = null;
    }
}

class MyLinkedList {
    Node head;
    Node tail;
    int size;
    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }
    
    public int get(int index) {
        if(index < 0 || index >= size){
            return -1;
        }else{
            Node temp = head;
            for(int i = 0; i < index; i++){
                temp = temp.next;
            }
            return temp.val;
        }
    }
    
    public void addAtHead(int val) {
        Node node = new Node(val);
        if(size == 0){
            head = tail = node;
        }else{
            node.next = head;
            head = node;
        }
        size++;
    }
    
    public void addAtTail(int val) {
        Node node = new Node(val);
        if(size == 0){
            head = tail = node;
        }else{
            tail.next = node;
            tail = node;
        }
        size++;
    }
    
    public void addAtIndex(int index, int val) {
        if(index < 0 || index > size){
            return;
        }else if(index == 0){
            addAtHead(val);
        }else if(index == size){
            addAtTail(val);
        }else{
            Node m1 = head;
            for(int i = 0; i < index - 1; i++){
                m1 = m1.next;
            }
            Node p1 = m1.next;
            Node node = new Node(val);
            m1.next = node;
            node.next = p1;
            size++;
        }
    }

    public void deleteAtHead(){
        if(size == 0){
            return;
        }else if(size == 1){
            head = tail = null;
        }else{
            head = head.next;
        }
        size--;
    }

    public void deleteAtTail(){
        if(size == 0){
            return;
        }else if(size == 1){
            head = tail = null;
        }else{
            Node temp = head;
            for(int i = 0; i < size - 2; i++){
                temp = temp.next;
            }
            tail = temp;
            temp.next = null;
        }
        size--;
    }
    
    public void deleteAtIndex(int index) {
        if(index < 0 || index >= size || size == 0){
            return;
        }else if(index == 0){
            deleteAtHead();
        }else if(index == size-1){
            deleteAtTail();
        }else{
            Node temp = head;
            for(int i = 0; i < index - 1; i++){
                temp = temp.next;
            }        
            temp.next = temp.next.next;
            size--;
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */