class Solution {
    public int arrangeCoins(int n) {
        long low=1, high=n;
        long mid= 0;

        while(high>=low){
            mid = low+(high-low)/2;
            long sum = mid*(mid+1)/2;
            System.out.println(sum);
            if(sum<=n){
                low = mid+1;
            }else{
                high = mid-1;
            }
            
        }
        return (int)high;
    }
}