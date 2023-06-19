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
        int flag=0;
        for(char c:s.toCharArray()){
            if(c=='@'){
                    break;
            }
            else if(c=='+'){
                flag=1;
            }
            else if(c!='.' && flag==0){
                sb.append(c);
            }
            i++;
        }
        
        sb.append(s.substring(i));
        return sb.toString();
    }
}