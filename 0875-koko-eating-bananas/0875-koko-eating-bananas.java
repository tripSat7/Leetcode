class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;

        for(int i : piles){
            if(i <min){
                min = i;
            }
            if(i>max){
                max = i;
            }
        }

        int low=1;
        int high=max;
        int ans = Integer.MAX_VALUE;
        while(low<=high){
            int mid = low + (high-low)/2;
            long hours = hoursTaken(mid, piles);
            if(hours > (long)h){
                low = mid+1;
            }else{
                high = mid-1;
                if(mid < ans){
                    ans = mid;
                }
            }
        }
        return ans;
    }

    public long hoursTaken(int k, int[] piles){
        long hours=0;
        for(int i : piles){
            if(i%k == 0){
                hours += (long)i/k;
            }else{
                hours += (long)i/k + 1;
            }
        }
        return hours;
    }
}