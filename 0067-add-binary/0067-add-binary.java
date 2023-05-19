class Solution {
    public String addBinary(String a, String b) {
        
        String result=a.length()>b.length()?addBinaryResult(a,b):addBinaryResult(b,a);
        
        return result;
    }
    
    public String addBinaryResult(String a, String b){
        String result="";
        int carry=0;
        int len1=a.length()-1;
        int len2=b.length()-1;
         while(len1>=0 && len2>=0){
            int s1=a.charAt(len1)-'0';
            int s2=b.charAt(len2)-'0';
            int rem= (s1+s2+carry)%2;
            carry=(s1+s2+carry)/2;
            result=rem+result;
            len1--;len2--;
        }
        
        while(len1>=0){
            int s1=a.charAt(len1)-'0';
            int rem= (s1+carry)%2;
            carry=(s1+carry)/2;
            result=rem+result;
            len1--;
        }
        if(carry==1){
            result=carry+result;
        }
        
        return result;
    }
}