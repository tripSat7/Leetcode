class Solution {
    public String firstPalindrome(String[] words) {
        String res;
        for(int i=0;i<words.length;i++){
            if(checkPallindrome(words[i])){
                return words[i];
            }
        }
        return "";
    }
    
    public static boolean checkPallindrome(String word){
        int left = (word.length()) / 2;
        int right = (word.length() - 1) / 2;
        while(left>=0){
            if(word.charAt(left--)!=word.charAt(right++)){
                return false;
            }
        }
        return true;
    }
}