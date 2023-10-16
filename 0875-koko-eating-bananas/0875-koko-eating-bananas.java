class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1, high = max(piles), ans = 0;
        while(low <= high){
            int mid = low + (high - low)/2;
            int time = getTime(mid, piles);
            if(time <= h){
                high = mid - 1;
                ans = mid;
            }
            else{
                low = mid + 1;
            }
        }
        return ans;
    }
    public int max(int[] piles){
        int maxi = Integer.MIN_VALUE;
        for(int i = 0; i < piles.length; i++){
            maxi = Math.max(piles[i], maxi);
        }
        return maxi;
    }

    public int getTime(int mid, int[] piles){
        int totalHours = 0;
        for(int i = 0; i < piles.length; i++){
            totalHours += Math.ceil((double)piles[i]/(double)mid);
        }
        return totalHours;
    }
}