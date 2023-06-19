class Solution {
    public String reverseWords(String s) {
        int sp=-1,ch=0,i=0;
        char arr[] = s.toCharArray();
        StringBuilder sb= new StringBuilder();
        int n = s.length();
        while(i<n){
            if(arr[i]==' '){
                sp++;
                ch++;
            }else{
                if(ch+1==s.length() || arr[ch+1]==' '){
                    String word = s.substring(sp+1,ch+1);
                    sb.insert(0,word);
                    sb.insert(0," ");
                    sp=ch;
                }
                ch++;
            }
            i++;
        }
        
        return sb.toString().trim();
    }
}