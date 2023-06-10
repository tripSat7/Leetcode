class Solution {
    public String destCity(List<List<String>> paths) { 
        Map<String,String> map = new HashMap<String,String>();
        
        for(List<String> lists:paths){
            map.put(lists.get(0),lists.get(1));
        }
        
        for(List<String> list:paths){
            String res = list.get(1); 
            if (!map.containsKey(res)) {
                return res; 
            }
        }
        
        return "";
    }
}