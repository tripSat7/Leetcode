class Solution {
    public boolean checkIfPangram(String sentence) {
        if(sentence.length()<26){
            return false;
        }
        for(char c='a';c<='z';c++){
            if(sentence.indexOf(c)==-1){
                return false;
            }
        }
        return true;
    }
}