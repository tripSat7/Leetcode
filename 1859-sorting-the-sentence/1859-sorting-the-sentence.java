class Solution {
    public String sortSentence(String s) {
        String res[] = new String[9];
        String s1[] = s.split(" ");
        StringBuilder result = new StringBuilder();
        for(String sb: s1){
            if(sb.charAt(sb.length()-1)-'0'==s1.length){
                res[sb.charAt(sb.length()-1)-'0'-1] = sb.substring(0,sb.length()-1);
            }else{
                res[sb.charAt(sb.length()-1)-'0'-1] = sb.substring(0,sb.length()-1)+" ";  
            }
        }
        
        for(String sb: res){
            if(sb!=null){
                result.append(sb);
            }
        }
        
        return result.toString();
    }
}