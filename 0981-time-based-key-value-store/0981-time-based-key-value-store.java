class TimeMap {

        class TimeVal{
        int timestamp;
        String value;

        public TimeVal(int timestamp, String value){
            this.timestamp = timestamp;
            this.value = value;
        }
    }

    Map<String, ArrayList<TimeVal>> map;

    public TimeMap() {
        map = new HashMap<>();    
    }
    
    public void set(String key, String value, int timestamp) {//O1
        if(map.containsKey(key)){
            map.get(key).add(new TimeVal(timestamp, value));
        } else {
            ArrayList<TimeVal> temp = new ArrayList();
            temp.add(new TimeVal(timestamp, value));
            map.put(key, temp);
        }
    }
    
    public String get(String key, int timestamp) {
        
        if (map.containsKey(key)){
            ArrayList<TimeVal> list = map.get(key);
            int left = 0;
            int right = list.size() - 1;
            String res = "";

            if(list.get(left).timestamp > timestamp){
                return "";
            } 
            if(list.get(right).timestamp <= timestamp){
                return list.get(right).value;
            }

            while(left <= right){
                int mid = (left+right)/2;

                if (list.get(mid).timestamp == timestamp){
                    return list.get(mid).value;
                }
                else if (list.get(mid).timestamp > timestamp){
                    right = mid-1;
                } else {
                    res = list.get(mid).value;
                    left = mid+1;
                }             
            }
            return res;
        }
        return "";
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */