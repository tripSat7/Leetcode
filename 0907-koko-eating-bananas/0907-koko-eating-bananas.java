class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for (int p : piles){
            max = Math.max(max, p);
        } 
        int i = 1;
        int j = max;
        while (i < j) {
            int mid = i + (j-i)/2;
            int hour = getHour(piles, mid);
            if (hour > h){
                i = mid + 1;
            } 
            else{
                j = mid;
            } 
        }
        return j;
    }

    private int getHour(int[] piles, int k) {
        int res = 0;
        for(int p : piles){
            res += (p + k - 1)/k;
        } 
        return res;
    }
}