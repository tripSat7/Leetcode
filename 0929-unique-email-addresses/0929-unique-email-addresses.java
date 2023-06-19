class Solution {
    public int numUniqueEmails(String[] emails) {
        if(emails.length == 1){
            return 1;
        } 
        Set<String> set = new HashSet<String>(emails.length);
        
        for(String s : emails){
            set.add(checkEmail(s));
        }
        
        return set.size();
    }
    
    public static String checkEmail(String s){
            
        StringBuilder sb = new StringBuilder();
        int i=0;
        for(; i<s.length();i++){
            char c = s.charAt(i);
            if(c=='@'){
                break;
            }
            else if(c=='+'){
                i= s.indexOf('@',i)-1;
            }
            else if(c!='.'){
                sb.append(c);
            }
        }
        
        sb.append(s.substring(i));
        return sb.toString();
    }
}