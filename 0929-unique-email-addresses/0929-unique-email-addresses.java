class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<String>(emails.length);
        
        for(String s : emails){
            set.add(checkEmail(s));
        }
        
        return set.size();
    }
    
    public static String checkEmail(String s){
            
        StringBuilder sb = new StringBuilder();
        int flag=0;
        for(char c:s.toCharArray()){
            if(c=='+' || c=='@'){
                    break;
            }
            // else if(c=='.' && flag=1){
            //     sb.append(c);
            // }
            if(c!='.' ){
                sb.append(c);
            }
        }
        if(sb.indexOf("@")==-1){
            sb.append(s.substring(s.indexOf('@')));
        }
        
        System.out.println(sb);
        return sb.toString();
    }
}