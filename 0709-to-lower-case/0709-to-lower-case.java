class Solution {
    public String toLowerCase(String s) {
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0;i<s.length();i++){
             int a;
            if(s.charAt(i)>='A' && s.charAt(i)<='Z'){
                a=97+s.charAt(i)-'A';
            }else{
                a=s.charAt(i);
            }
            sb.append((char)a);
        }
        return sb.toString();
    }
}