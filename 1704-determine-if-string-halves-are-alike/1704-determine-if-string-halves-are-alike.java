class Solution {
    public boolean halvesAreAlike(String s) {
        // char ch[] = s.toCharArray();
        int count=0,left=(s.length()/2)-1,right=left+1;
        //List<Character> vowels = new ArrayList<Character>(Arrays.asList('a','e','i','o','u','A','E','I','O','U'));
        while(left>=0){
            if(isVowel(s.charAt(left))){
                count++;
            }
            if(isVowel(s.charAt(right))){
                count--;
            }
            left--;right++;
        }
        return count==0;
    }
    
    public static boolean isVowel(char c){
        if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u'||c=='A'||c=='E'||c=='I'||c=='O'||c=='U'){
            return true;
        }
        return false;
    }
}