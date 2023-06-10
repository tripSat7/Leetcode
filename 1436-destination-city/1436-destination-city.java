class Solution {
    public String destCity(List<List<String>> paths) {
        if(paths.size()==1){
           return paths.get(0).get(1);
        } 
        Map<String,String> map = new HashMap<String,String>();
        for(List<String> lists:paths){
            map.put(lists.get(0),lists.get(1));
        }
        String start=paths.get(0).get(0),res = start;
        while(map.containsKey(start)){
            res=map.get(start);
            start=res;
        }
        return res;
    }
}