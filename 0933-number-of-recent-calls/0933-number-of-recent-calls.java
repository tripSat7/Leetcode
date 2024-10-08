class RecentCounter {
    int[] records = new int[10000]; 
    int start;
    int end;

    public RecentCounter() {        
        start = 0;
        end = 0;
    }
    
    public int ping(int t) {
        
        records[end++] = t;
        
        while (start < end && (t - records[start] > 3000)) { 
            start++;
        }
        
        return end - start;
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */