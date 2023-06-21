class Solution {
    public boolean isIsomorphic(String s, String t) {
        int map1[] = new int[127];
        int map2[] = new int[127];
        char ch1[] = s.toCharArray();
        char ch2[] = t.toCharArray();
        
        for(int i=0;i<s.length();i++){
            map1[ch1[i]] = ch2[i];
            map2[ch2[i]] = ch1[i];
        }
        
        for(int i=0; i<ch1.length; i++){
            if(!(map1[ch1[i]]==ch2[i] && map2[ch2[i]]==ch1[i])){
                return false;
            }
        }
        
        return true;
    }
}