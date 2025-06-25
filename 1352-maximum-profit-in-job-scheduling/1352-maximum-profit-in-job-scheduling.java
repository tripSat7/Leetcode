// Time Complexity: O(n log n)
// Space Complexity: O(n)

public class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = profit.length;
        int[][] jobs = new int[n][3];
        for (int i = 0; i < n; i++) {
            jobs[i][0] = startTime[i];
            jobs[i][1] = endTime[i];
            jobs[i][2] = profit[i];
        }
        Arrays.sort(jobs, (a, b) -> a[1] - b[1]); // Sort by end time

        int[] dp = new int[n];
        dp[0] = jobs[0][2];

        for (int i = 1; i < n; i++) {
            int take = jobs[i][2];
            int last = binarySearch(jobs, i, jobs[i][0]);

            if (last != -1) {
                take += dp[last];
            }
            
            int skip = dp[i - 1];
            dp[i] = Math.max(take, skip);
        }
        return dp[n - 1];
    }

    // Find the last job that ends <= startTime, among jobs[0...right-1]
    private int binarySearch(int[][] jobs, int right, int startTime) {
        int left = 0, res = -1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (jobs[mid][1] <= startTime) {
                res = mid;
                left = mid + 1;
            } 
            else {
                right = mid;
            }
        }
        return res;
    }
}
