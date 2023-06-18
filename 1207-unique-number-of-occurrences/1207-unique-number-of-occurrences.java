class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i:arr){
            if(map.containsKey(i)){
                map.put(i,map.get(i)+1);
            }else{
                map.put(i,1);
            }
        }
        Set<Integer> set = new HashSet<Integer>();
        for(Map.Entry m : map.entrySet()){
            int temp = (int)m.getValue();
            if(set.contains(temp)){
                return false;
            }else{
                set.add(temp);
            }
        }
        
        return true;
    }
}