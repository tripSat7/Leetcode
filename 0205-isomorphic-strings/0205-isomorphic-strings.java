class Solution {
    public boolean isIsomorphic(String s, String t) {
        int map1[] = new int[128];
        int map2[] = new int[128];
        
        for(int i=0;i<s.length();i++){
            int s1 = s.charAt(i);
            int s2 = t.charAt(i);
            map1[s1] = s2;
            map2[s2] = s1;
        }
        
        for(int i=0; i<s.length(); i++){
            int s1 = s.charAt(i);
            int s2 = t.charAt(i);
            if(!(map1[s1]==s2 && map2[s2]==s1)){
                return false;
            }
        }
        return true;
    }
}