class TimeMap {

    HashMap<String, TreeMap<Integer, String>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        
        if(map.containsKey(key)){
            map.get(key).put(timestamp, value);
            // System.out.print("Already there---");
            // System.out.println(map);
        }
        else{
            TreeMap<Integer,String> tmap = new TreeMap<>();
            tmap.put(timestamp,value);
            map.put(key, tmap);
            // System.out.print("New---");
            // System.out.println(map);
        }
    }
    
    public String get(String key, int timestamp) {
        
        if(!map.containsKey(key)){
            return "";
        }
        
        TreeMap<Integer, String> tMap = map.get(key);
        if(tMap.containsKey(timestamp)){
            return tMap.get(timestamp);
        }
        else
        {
            Integer k = tMap.lowerKey(timestamp);
            if(k == null){
                return "";
            }
            return tMap.get(k);
        }
        
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */