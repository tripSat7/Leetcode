class Solution {
    public String reverseVowels(String s) {
        int i=0, j=s.length()-1;
        List<Character> vowels = new ArrayList (Arrays.asList('a','A','e','E','i','I','o','O','u','U'));
        StringBuilder sb = new StringBuilder(s);
        
        while(i<j){
            if(!vowels.contains(sb.charAt(i))){
                i++;
            }
            
            if(!vowels.contains(sb.charAt(j))){
                j--;
            }
            
            if(vowels.contains(sb.charAt(i))&&vowels.contains(sb.charAt(j))){
                char temp = sb.charAt(i);
                sb.setCharAt(i,sb.charAt(j));
                sb.setCharAt(j,temp);
                i++;j--;
                
            }
        }
        
        
        
        return sb.toString();
    }
}