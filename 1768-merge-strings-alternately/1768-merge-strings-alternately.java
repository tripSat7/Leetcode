class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int n = word1.length()>word2.length()?word2.length():word1.length();
        int max = word1.length()>word2.length()?word1.length():word2.length();
        int i;
        for(i=0;i<n;i++){
            sb.append(word1.charAt(i));
            sb.append(word2.charAt(i));
        }
        
        while(i<max){
            if(i>=word2.length()){
                sb.append(word1.charAt(i));
            }else{
                sb.append(word2.charAt(i)); 
            }
            i++;
        }
        
        return sb.toString();
    }
}