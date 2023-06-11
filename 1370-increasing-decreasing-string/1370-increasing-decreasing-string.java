class Solution {
    public String sortString(String s) {
        char ch[] = s.toCharArray();
        int count[] = new int[26];
        for(int i=0; i<ch.length;i++){
            count[ch[i]-'a']+=1;
        }
        int sc = s.length();
        char res[] = new char[s.length()];
        int len=0;
        while(sc!=0){
            for(int i=0;i<count.length;i++){
                if(count[i]!=0){
                    res[len++] = (char)('a'+i);
                    count[i]-=1;
                    sc--;   
                }
            }
            
            for(int i=count.length-1;i>=0;i--){
                if(count[i]!=0){
                    res[len++] = (char)('a'+i);
                    count[i]-=1;
                    sc--;
                }
            }
                
        }
        
        return String.valueOf(res);
    }
}