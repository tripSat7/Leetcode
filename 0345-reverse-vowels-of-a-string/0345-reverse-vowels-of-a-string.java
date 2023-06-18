class Solution {
    public String reverseVowels(String s) {
        int i=0, j=s.length()-1;
        char ch[] = s.toCharArray();
        while(i<j){
            if(!isVowel(ch[i])){
                i++;
            }
            
            if(!isVowel(ch[j])){
                j--;
            }
            
            if(isVowel(ch[i])&&isVowel(ch[j])){
                char temp = ch[i];
                ch[i]=ch[j];
                ch[j]=temp;
                i++;j--;
                
            }
        }
        
        return new String(ch);
    }
    
    public static boolean isVowel(char c){
        if(c=='a'||c=='A'||c=='e'||c=='E'||c=='i'||c=='I'||c=='o'||c=='O'||c=='u'||c=='U'){
            return true;
        }
        return false;
    }
}