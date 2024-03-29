class Solution {
    public boolean isPerfectSquare(int num) {
        long low=1, high=num, mid=0;
        while(high>=low){
            mid=low+(high-low)/2;
            if(mid*mid==num){
                return true;
            }else if(mid*mid>num){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return false;
    }
}