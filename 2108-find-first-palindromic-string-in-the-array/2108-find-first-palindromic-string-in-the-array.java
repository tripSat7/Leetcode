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
        int left = 0, right = word.length()-1;
        while(left<right){
            if(word.charAt(left++)!=word.charAt(right--)){
                return false;
            }
        }
        return true;
    }
}