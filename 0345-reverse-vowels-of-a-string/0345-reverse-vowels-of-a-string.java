class Solution {
    public String reverseVowels(String s) {
        int i=0, j=s.length()-1;
        // List<Character> vowels = new ArrayList (Arrays.asList('a','A','e','E','i','I','o','O','u','U'));
        StringBuilder sb = new StringBuilder(s);
        
        while(i<j){
            if(!isVowel(sb.charAt(i))){
                i++;
            }
            
            if(!isVowel(sb.charAt(j))){
                j--;
            }
            
            if(isVowel(sb.charAt(i))&&isVowel(sb.charAt(j))){
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