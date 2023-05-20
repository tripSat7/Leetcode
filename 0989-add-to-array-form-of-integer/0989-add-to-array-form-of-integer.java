class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        int carry = 0;
        List<Integer> result = new ArrayList<Integer>();
        int i = num.length-1;
        while(i>=0||k!=0){
            int sum = 0;
            sum = sum + carry;
            if(k!=0){
                int rem = k%10;
                sum = sum + rem;
                k=k/10;
            }
            if(i>=0){
                sum = sum + num[i];
                i--;
            }
            carry = sum/10;
            sum = sum%10;
            result.add(0,sum);
        }
        if(carry!=0){
            result.add(0,carry);
        }
        return result;
    }
}