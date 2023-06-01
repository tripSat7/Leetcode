class Solution {
    public String decodeMessage(String key, String message) {
        HashMap<Character,Character> map = new HashMap<Character,Character>();
        StringBuilder res = new StringBuilder();
        
        int i=0;
        char c='a';
        map.put(' ',' ');
        while(i<key.length()){
            if(!map.containsKey(key.charAt(i))){
                map.put(key.charAt(i),c);
                c++;
            }
            i++;
        }
        
        for(i=0;i<message.length();i++){
            res.append(map.get(message.charAt(i)));
        }
        
        return res.toString();
    }
}