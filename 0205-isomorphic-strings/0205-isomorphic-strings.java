class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character,Character> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(!map.containsValue(t.charAt(i))){
                map.put(s.charAt(i),t.charAt(i));   
            }
        }
        String res = "";
        for(char ch: s.toCharArray()){
            res = res + map.get(ch);
        }
        System.out.println(res);
        
        return res.equals(t);
    }
}