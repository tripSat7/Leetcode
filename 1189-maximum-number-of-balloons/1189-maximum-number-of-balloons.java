class Solution {
    public int maxNumberOfBalloons(String text) {
        int chars[] = new int[26];
        for(char c:text.toCharArray()){
            chars[c-'a']++;
        }
        if(chars[0]==0 || chars[1] ==0 || chars['l'-'a'] <2 || chars['o'-'a']<2 || chars['n'-'a']==0){
            return 0;
        }
        
        int minOL = chars['l'-'a']/2 >chars['o'-'a']/2?chars['o'-'a']/2:chars['l'-'a']/2;
        int minABN = Math.min(Math.min(chars[0], chars[1]), chars['n'-'a']);
        return minOL>minABN?minABN:minOL;
    }
}