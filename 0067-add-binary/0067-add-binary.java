class Solution {
    public String addBinary(String a, String b) {
        
        String result=a.length()>b.length()?addBinaryResult(a,b):addBinaryResult(b,a);
        
        return result;
    }
    
    public String addBinaryResult(String a, String b){
        StringBuilder result= new StringBuilder();
        int carry=0;
        char ch1[] = a.toCharArray();
        char ch2[] = b.toCharArray();
        int len1=a.length()-1;
        int len2=b.length()-1;
         while(len1>=0 && len2>=0){
            int s1=ch1[len1]-'0';
            int s2=ch2[len2]-'0';
            int rem= (s1+s2+carry)%2;
            carry=(s1+s2+carry)/2;
            result.append(rem);
            len1--;len2--;
        }
        
        while(len1>=0){
            int s1=ch1[len1]-'0';
            int rem= (s1+carry)%2;
            carry=(s1+carry)/2;
            result.append(rem);
            len1--;
        }
        if(carry!=0){
            result.append(carry);
        }
        
        return result.reverse().toString();
    }
}