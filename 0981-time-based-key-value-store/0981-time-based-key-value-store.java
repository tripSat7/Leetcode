class TimeMap {

        class Pair{
        int timestamp;
        String value;

        public Pair(int timestamp, String value){
            this.timestamp = timestamp;
            this.value = value;
        }
    }

    Map<String, ArrayList<Pair>> map;

    public TimeMap() {
        map = new HashMap<>();    
    }
    
    public void set(String key, String value, int timestamp) {//O1
        if(map.containsKey(key)){
            map.get(key).add(new Pair(timestamp, value));
        } else {
            ArrayList<Pair> temp = new ArrayList();
            temp.add(new Pair(timestamp, value));
            map.put(key, temp);
        }
    }
    
    public String get(String key, int timestamp) {
        
        if (map.containsKey(key)){
            ArrayList<Pair> list = map.get(key);
            int left = 0;
            int right = list.size() - 1;
            String holder = "";

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
                    holder = list.get(mid).value;
                    left = mid+1;
                }             
            }
            return holder;
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