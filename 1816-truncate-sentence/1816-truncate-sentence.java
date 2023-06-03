class Solution {
    public String truncateSentence(String s, int k) {
        String res[] = s.split(" ");
        StringBuilder sb = new StringBuilder();
        
        for(int i=0;i<k-1;i++){
            sb.append(res[i]);
            sb.append(" ");
        }
        sb.append(res[k-1]);
        
        return sb.toString();
    }
}