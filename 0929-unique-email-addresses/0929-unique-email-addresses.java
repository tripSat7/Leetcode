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
        int i=0;
        int flag=0;
        for(char c:s.toCharArray()){
            if(c=='@'){
                    break;
            }
            if(c=='+'){
                flag=1;
            }
            if(c!='.' && flag==0){
                sb.append(c);
            }
            i++;
        }
        
        sb.append(s.substring(i));
        
        System.out.println(sb);
        return sb.toString();
    }
}