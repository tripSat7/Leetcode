class Solution {
    public String defangIPaddr(String address) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while(i<address.length()){
            if(address.charAt(i)!='.'){
                sb.append(address.charAt(i));
            }
            if(address.charAt(i)=='.'){
                sb.append("[.]");
            }
            i++;
        }
        
        return sb.toString();
    }
}