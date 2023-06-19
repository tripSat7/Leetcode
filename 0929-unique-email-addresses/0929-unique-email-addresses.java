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
        char c[] = s.toCharArray();
        int i=0;
        for(; i<s.length();i++){
            if(c[i]=='@'){
                break;
            }
            else if(c[i]=='+'){
                i= s.indexOf('@',i)-1;
            }
            else if(c[i]!='.'){
                sb.append(c[i]);
            }
        }
        
        sb.append(s.substring(i));
        return sb.toString();
    }
}