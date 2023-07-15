class ListNode{
    ListNode next;
    int key, val;
    
    ListNode(int key, int val){
        this.key = key;
        this.val = val;
    }
}

class MyHashMap {

    ListNode hashMap[];
    int size;
    public MyHashMap() {
        size = 10000;//10^4 is the max no of calls being made
        hashMap = new ListNode[size];
    }
    
    public int hash(int key){
        return key%size;
    }
    
    public void put(int key, int value) {
        int index = hash(key);
        if(hashMap[index]==null){
            hashMap[index] = new ListNode(key,value); 
        }else{
            ListNode temp = hashMap[index];
            while(true){
                if(temp.key==key){
                    temp.val = value;
                    return;
                }
                if(temp.next==null){
                    break;
                }
                temp = temp.next;
            }
            temp.next = new ListNode(key,value);
        }
    }
    
    public int get(int key) {
        int index = hash(key);
        ListNode temp = hashMap[index];
        while(temp!=null){
            if(temp.key==key){
                return temp.val;
            }
            temp = temp.next;
        }
        
        return -1;
    }
    
    public void remove(int key) {
        int index = hash(key);
        ListNode temp = hashMap[index];
        ListNode prev = null;
        
        while(temp!=null){
            if(temp.key==key){
                if(prev == null){
                    hashMap[index] = temp.next;
                }else{
                    prev.next = temp.next;
                }
                return;
            }
            prev = temp;
            temp = temp.next;
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