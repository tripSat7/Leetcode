class Solution {
    public int[] diStringMatch(String s) {
        int res[] = new int[s.length()+1];
        int ic=0,dc=s.length();
        int i;
        char ch[]=s.toCharArray();
        for(i=0;i<ch.length;i++){
            if(ch[i]=='I'){
                res[i] = ic;
                ic++;
            }else{
                res[i] = dc;
                dc--;
            }
        }
        
        res[i]=ic;
        return res;
    }
}