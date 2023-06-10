class Solution {
    public int[] diStringMatch(String s) {
        int res[] = new int[s.length()+1];
        int ic=0,dc=s.length();
        int i=0;
        
        for(char ch:s.toCharArray()){
            if(ch=='I'){
                res[i] = ic;
                ic++;
            }else{
                res[i] = dc;
                dc--;
            }
            i++;
        }
        
        res[i]=ic;
        return res;
    }
}