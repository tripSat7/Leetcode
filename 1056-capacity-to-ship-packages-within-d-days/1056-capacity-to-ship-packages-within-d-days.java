// Time Complexity: O(N log S)
//   N = number of weights
//   S = sum of all weights - max individual weight (the search space size)
//   For each binary search iteration, we scan all weights (O(N)), and the number of iterations is O(log(sum(weights) - max(weights)))
// Space Complexity: O(1)

class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int min = 0; 
        int max = 0; 

        for (int weight : weights) {
            if (min < weight) {
                min = weight;
            }
            max += weight;
        }

        while (min < max) {
            int mid = (max + min) / 2;
            int cur = 0, d = 1; // cur: current load, d: days used

            // Try to ship with this capacity in as few days as possible
            for (int weight : weights) {
                // If adding this weight exceeds capacity, start new day
                if (cur + weight > mid) {
                    d++;
                    cur = 0;
                }
                cur += weight;
            }

            // If d > days, it means that we are'nt shipping enough packages per day, therefore increase the min weight
            if (days < d) {
                min = mid + 1;
            } 
            else {
                max = mid;
            }
        }

        return max; // At the end, min == max: minimal possible ship capacity
    }
}
