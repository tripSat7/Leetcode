class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<String>(emails.length);
        
        for(String s : emails){
            String temp[] = s.split("@");
            String loc = temp[0];
            String dom = temp[1];
            StringBuilder sb = new StringBuilder();
            for(char c:loc.toCharArray()){
                if(c=='+'){
                    break;
                }
                if(c!='.'){
                    sb.append(c);
                }
            }
            sb.append("@");
            sb.append(dom);
            if(!set.contains(sb.toString())){
                set.add(sb.toString());
            }
        }
        
        return set.size();
    }
}