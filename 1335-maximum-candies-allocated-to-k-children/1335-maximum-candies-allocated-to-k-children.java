class Solution {
    public int maximumCandies(int[] candies, long k) {
        long sum = 0;
        int max = candies[0];
        for(int i : candies){
            sum += i;
            max = Math.max(max, i);
        }

        if(sum < k){
            return 0;
        }

        int low = 1, high = max;
        while(low < high){
            int mid = (low + high + 1)/2;
            // System.out.println(low+"||"+high);
            if(canDivide(candies, k, mid)){
                low = mid;
            }
            else{
                high = mid - 1;
            }
        }
        
        return low;
    }

    public boolean canDivide(int[] candies, long k, int maxCandy){
        
        long count = 0;
        for(int i : candies){
            count += i/maxCandy;
        }

        return count >= k;
    }
}