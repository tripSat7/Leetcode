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
        char ch[] = word.toCharArray();
        int left = 0, right = ch.length-1;
        while(left<right){
            if(ch[left]!=ch[right]){
                return false;
            }
            left++;right--;
        }
        return true;
    }
}