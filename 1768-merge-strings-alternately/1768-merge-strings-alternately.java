class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int n = word1.length()>word2.length()?word2.length():word1.length();
        int max = word1.length()>word2.length()?word1.length():word2.length();
        int i;
        char ch1[] = word1.toCharArray();
        char ch2[] = word2.toCharArray();
        for(i=0;i<n;i++){
            sb.append(ch1[i]+""+ch2[i]);
        }
        
        if(i>=word2.length()){
            while(i<max){
                sb.append(ch1[i]);
                i++;
            }
        }
        else{
            while(i<max){
                sb.append(ch2[i]);
                i++;
            }
        }
        
        return sb.toString();
    }
}