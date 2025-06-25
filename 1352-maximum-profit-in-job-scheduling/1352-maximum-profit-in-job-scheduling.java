// Time Complexity: O(n^2) (due to nested linear scan for previous job, can be optimized to O(n log n) with binary search)
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
        dp[0] = jobs[0][2]; // Base case: only the first job

        for (int i = 1; i < n; i++) {
            int take = jobs[i][2];
            int last = -1;
            // Find last job that doesn't overlap
            for (int j = i - 1; j >= 0; j--) {
                if (jobs[j][1] <= jobs[i][0]) {
                    last = j;
                    break;
                }
            }
            if (last != -1) {
                take += dp[last]; // Add profit from last compatible job
            }
            int skip = dp[i - 1]; // Skip current job
            dp[i] = Math.max(take, skip); // Max profit at this point
        }
        return dp[n - 1]; // Max profit using all jobs
    }
}
