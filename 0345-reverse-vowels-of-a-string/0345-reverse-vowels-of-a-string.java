class Solution {
    public String reverseVowels(String s) {
        int i=0, j=s.length()-1;
        StringBuilder sb = new StringBuilder(s);
        char ch[] = s.toCharArray();
        while(i<j){
            if(!isVowel(ch[i])){
                i++;
            }
            
            if(!isVowel(ch[j])){
                j--;
            }
            
            if(isVowel(ch[i])&&isVowel(ch[j])){
                char temp = sb.charAt(i);
                sb.setCharAt(i,sb.charAt(j));
                sb.setCharAt(j,temp);
                i++;j--;
                
            }
        }
        
        return sb.toString();
    }
    
    public static boolean isVowel(char c){
        if(c=='a'||c=='A'||c=='e'||c=='E'||c=='i'||c=='I'||c=='o'||c=='O'||c=='u'||c=='U'){
            return true;
        }
        return false;
    }
}