class MyHashMap {

    boolean keyMap[];
    int valueMap[]; 
    public MyHashMap() {
        keyMap = new boolean[1000001];
        valueMap = new int[1000001];
    }
    
    public void put(int key, int value) {
        keyMap[key] = true;
        valueMap[key] = value;
    }
    
    public int get(int key) {
        
        return keyMap[key]==true?valueMap[key]:-1;
    }
    
    public void remove(int key) {
        keyMap[key] = false;
        valueMap[key] = -1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */