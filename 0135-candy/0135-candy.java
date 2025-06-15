// TC : O(n)
// SC : O(1)

class Solution {
    public int candy(int[] ratings) {
        int res = 1, i = 1;
        int n = ratings.length;

        while (i < n) {

            // If ratings are equal, give 1 candy and move on
            if (ratings[i] == ratings[i - 1]) {
                res++;
                i++;
                continue;
            }

            // Handle strictly increasing sequence (uphill)
            int peak = 1;
            while (i < n && ratings[i] > ratings[i - 1]) {
                peak++;
                res += peak;
                i++;
            }

            // Handle strictly decreasing sequence (downhill)
            int downPeak = 1;
            while (i < n && ratings[i - 1] > ratings[i]) {
                res += downPeak;
                downPeak++;
                i++;
            }

            // If the downPeak > peak, we didn't give enough candies at the peak to satisfy the decreasing side.
            if (downPeak > peak) {
                res += downPeak - peak;
            }
        }

        return res;
    }
}
