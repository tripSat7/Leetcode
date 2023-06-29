class Solution {
    public String addStrings(String num1, String num2) {
        int carry = 0;
        int i = num1.length()-1;
        int j = num2.length()-1;
        char ch1[] = num1.toCharArray();
        char ch2[] = num2.toCharArray();
        StringBuilder result = new StringBuilder();
        while(i>=0||j>=0){
            int sum = 0;
            sum+= carry;
            if(i>=0){
                int n1 = ch1[i]-'0';
                sum += n1;
                i--;
            }
            if(j>=0){
                int n2 = ch2[j]-'0';
                sum+=n2;
                j--;
            }
            result.append(sum%10);
            carry = sum/10;
        }
        
        if(carry!=0){
            result.append(carry); 
        }
        return result.reverse().toString();
    }
}