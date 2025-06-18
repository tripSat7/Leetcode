class LFUCache {

    private int capacity;
    private int minFreq = 0;
    private Map<Integer, Integer> keyToVal = new HashMap<>();
    private Map<Integer, Integer> keyToFreq = new HashMap<>();
    private Map<Integer, LinkedHashSet<Integer>> freqToLRUKeys = new HashMap<>();

    public LFUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if (!keyToVal.containsKey(key)) {
            return -1;
        }

        int freq = keyToFreq.get(key);
        // Remove key from its current freq bucket
        freqToLRUKeys.get(freq).remove(key);

        // If it was the only key at minFreq, remove the freq & increase minFreq
        if (freq == minFreq && freqToLRUKeys.get(freq).isEmpty()) {
            freqToLRUKeys.remove(freq); 
            ++minFreq;
        }

        // Promote key to freq+1
        putFreq(key, freq + 1);
        return keyToVal.get(key);
    }


    private void putFreq(int key, int freq) {
        keyToFreq.put(key, freq); //update freq of the key
        freqToLRUKeys.putIfAbsent(freq, new LinkedHashSet<>());//create a new key for freq list if not present already
        freqToLRUKeys.get(freq).add(key); // add the node in this freq tier
    }
    
    public void put(int key, int value) {
        if (capacity == 0){
            return;
        }
        
        if(keyToVal.containsKey(key)) {
            keyToVal.put(key, value);
            get(key); // Update key's count
            return;
        }

        if (keyToVal.size() == capacity) {
            // remove LRU key from the minFreq list
            int keyToRemove = freqToLRUKeys.get(minFreq).iterator().next();
            freqToLRUKeys.get(minFreq).remove(keyToRemove);
            keyToVal.remove(keyToRemove);
        }

        minFreq = 1;
        putFreq(key, minFreq);    // Add new key and freq
        keyToVal.put(key, value); // Add new key and value
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */