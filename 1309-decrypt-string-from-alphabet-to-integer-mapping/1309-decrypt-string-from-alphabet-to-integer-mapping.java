class Solution {
    public String freqAlphabets(String s) {
        char ch[] = s.toCharArray();
        StringBuilder res = new StringBuilder();
        
        for(int i = ch.length-1;i>=0;i--){
            if(ch[i]=='#'){
                int n = 10*(ch[i-2]-'0')+ch[i-1]-'0';
                res.insert(0,(char)('a'+n-1));
                i=i-2;
            }else{
                res.insert(0,(char)('a'+ch[i]-'0'-1));
            }
        }
        return res.toString();
    }
}