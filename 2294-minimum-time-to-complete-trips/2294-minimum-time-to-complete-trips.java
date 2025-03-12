class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        long max = Integer.MIN_VALUE;

        for(int i : time){
            max = Math.max(i, max);
        }

        long low = 0, high = 1L * max * totalTrips;
        // System.out.println(low+"||"+high);
        while(low < high){
            long mid = low + (high - low)/2;

            if(canFinish(time, totalTrips, mid)){
                high = mid;
            }
            else{
                low = mid + 1;
            }
        }

        return low;
    }

    public boolean canFinish(int[] time, int totalTrips, long t){
        long res = 0;

        for(int i : time){
            res = res + (t / i);

            if(res >= totalTrips){
                return true;
            }
        }

        return false;
    }
}