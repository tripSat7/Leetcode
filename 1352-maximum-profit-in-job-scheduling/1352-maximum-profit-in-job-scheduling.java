// Time Complexity: O(n log n)
//   - Sorting jobs: O(n log n)
//   - For each job, binary search: O(log n) * n
// Space Complexity: O(n) for jobs and dp array

public class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = profit.length;
        int[][] jobs = new int[n][3];
        // Build array of jobs: [start, end, profit]
        for (int i = 0; i < n; i++) {
            jobs[i][0] = startTime[i];
            jobs[i][1] = endTime[i];
            jobs[i][2] = profit[i];
        }

        Arrays.sort(jobs, (a, b) -> a[1] - b[1]); // Sort jobs by end time

        int[] dp = new int[n];
        dp[0] = jobs[0][2]; // Base case: first job's profit

        // For each job, decide: take or skip
        for (int i = 1; i < n; i++) {
            int take = jobs[i][2];
            // Find last non-overlapping job using binary search
            int last = binarySearch(jobs, i, jobs[i][0]);
            if (last != -1) {
                take += dp[last];
            }
            int skip = dp[i - 1]; // Don't take current job
            dp[i] = Math.max(take, skip); // Max profit up to this job
        }
        return dp[n - 1]; // Max profit using all jobs
    }

    // Binary search: last job before i that ends <= startTime
    private int binarySearch(int[][] jobs, int right, int startTime) {
        int left = 0, res = -1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (jobs[mid][1] <= startTime) {
                res = mid; // Candidate found, try further right
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return res;
    }
}
