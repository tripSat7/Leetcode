class Solution {
    public boolean areOccurrencesEqual(String s) {
        char ch[] = s.toCharArray();
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        for(char c:ch){
            if(map.containsKey(c)){
                map.put(c,map.get(c)+1);
            }else{
                map.put(c,1);
            }
        }
        int count = map.get(ch[0]);
        for(char ch1:ch){
            if(map.get(ch1)!=count){
                return false;
            }
        }
        return true;
    }
}