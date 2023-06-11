class Solution {
    public boolean areOccurrencesEqual(String s) {
        char ch[] = s.toCharArray();
        int count[] = new int[26];
        for(char c:ch){
            count[c-'a']+=1;
        }
        int cv=count[ch[0]-'a'];
        for(int i=0;i<count.length;i++){
            if(count[i]!=0 && count[i]!=cv){
                return false;
            }
        }
        return true;
    }
}