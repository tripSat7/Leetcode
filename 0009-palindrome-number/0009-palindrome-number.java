class Solution {
    public boolean isPalindrome(int x) {
        if(x==0){
            return true;
        }
        if(x<0 || x%10==0){
            return false;
        }
        
        int rev=0, temp=x;
        while(temp>0){
            int rem = temp%10;
            rev = rev*10 + rem;
            temp = temp/10;
        }
        
        return rev==x;
    }
}