class MyHashSet {
 
      boolean[] keys = new boolean[1000001];
    public MyHashSet() {
        
    }
    
    public void add(int key) {
        keys[key]=true;
    }
    
    public void remove(int key) {
        keys[key]=false;
    }
    
    public boolean contains(int key) {
        return keys[key];
    }
}
