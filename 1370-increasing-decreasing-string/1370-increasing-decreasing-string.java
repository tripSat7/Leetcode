class Solution {
    public String sortString(String s) {
        char ch[] = s.toCharArray();
        int count[] = new int[26];
        for(int i=0; i<ch.length;i++){
            count[ch[i]-'a']+=1;
        }
        boolean fc=true;
        int sc = s.length();
        String res = "";
        int i=0;
        while(sc!=0){
            if(fc){
                for(i=0;i<count.length;i++){
                    if(count[i]!=0){
                        res = res+(char)('a'+i);
                        count[i]-=1;
                        sc--;   
                    }
                }
                fc=false;
            }else{
                for(i=count.length-1;i>=0;i--){
                    if(count[i]!=0){
                        res = res+(char)('a'+i);
                        count[i]-=1;;
                        sc--;
                    }
                }
                fc=true;
            }
        }
        
        return res;
    }
}