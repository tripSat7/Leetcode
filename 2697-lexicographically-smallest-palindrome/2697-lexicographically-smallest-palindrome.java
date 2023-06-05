class Solution {
    public String makeSmallestPalindrome(String s) {
        StringBuilder sb = new StringBuilder(s);
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)>s.charAt(s.length()-i-1)){
                sb.setCharAt(i,s.charAt(s.length()-i-1));
            }else{
                sb.setCharAt(s.length()-i-1,s.charAt(i));
            }
        }
        
        return sb.toString();
    }
}