class Solution {
    public int[] diStringMatch(String s) {
        int n= s.length();
        int res[] = new int[n+1];
        int ic=0,dc=n;
        int i;
        char ch[]=s.toCharArray();
        for(i=0;i<n;i++){
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