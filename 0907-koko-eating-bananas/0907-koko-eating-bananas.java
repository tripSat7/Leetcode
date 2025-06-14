/**
 Time Complexity: O(N * logM)
 N = number of piles
 M = max number of bananas in any pile
 Space Complexity: O(1)
 */
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        
        for (int p : piles){
            max = Math.max(max, p);
        } 
        // left and right boundaries 
        int i = 1;
        int j = max;

        //O(log M)
        while (i < j) {
            int mid = i + (j-i)/2;
            // hour stands for the total hour Koko spends.
            int hour = getHour(piles, mid);
            if (hour > h){//eating rate too slow, so increase rate
                i = mid + 1;
            } 
            else{//eating rate too fast, so decrease rate
                j = mid;
            } 
        }
        return j;
    }

    private int getHour(int[] piles, int k) {
        int res = 0;
        
        //O(n)
        for(int p : piles){
            res += (p + k - 1)/k; 
            //using (numerator + denom - 1)/denom to get the ceil value
        } 
        
        return res;
    }
}