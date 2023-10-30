class TimeVal {
    int timestamp;
    String value;

    TimeVal(int timestamp, String value) {
        this.timestamp = timestamp;
        this.value = value;
    }
}

class TimeMap {

    HashMap<String, ArrayList<TimeVal>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        
        if(map.containsKey(key)){
            map.get(key).add(new TimeVal(timestamp,value));
            // System.out.print("Already there---");
            // System.out.println(map);
        }
        else{
            ArrayList<TimeVal> list = new ArrayList<>();
            list.add(new TimeVal(timestamp,value));
            map.put(key, list);
            // System.out.print("New---");
            // System.out.println(map);
        }
    }
    
    public String get(String key, int timestamp) {
        
        String res = "";
        
        if(map.containsKey(key)){
            ArrayList<TimeVal> list = map.get(key);
            int low = 0, high = list.size()-1;
            
            while(low <= high){
                int mid = low + (high-low)/2;
                if(list.get(mid).timestamp == timestamp){
                    return list.get(mid).value;
                }
                else if(list.get(mid).timestamp < timestamp){
                    res = list.get(mid).value;
                    low = mid + 1;
                }
                else{
                    high = mid -1;
                }
            }
        }
        
        return res;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */