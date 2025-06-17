// TC : O(n * log n) due to sorting
// SC : O(n) for separate start and end arrays

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int n = intervals.length;
        int[] start = new int[n];
        int[] end = new int[n];
        
        // Separate out start and end times
        for (int i = 0; i < n; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        
        // Sort start and end times independently
        Arrays.sort(start);
        Arrays.sort(end);
        
        int res = 0;       // Max rooms needed at any point
        int count = 0;     // Current number of overlapping meetings
        int s = 0, e = 0;  // Pointers for start and end arrays

        // Traverse all start times
        while (s < n) {
            if (start[s] < end[e]) {
                // A new meeting starts before the current one ends
                count++;
                s++;
            } else {
                // A meeting ends before or at the next one’s start
                count--;
                e++;
            }
            // Update result with max rooms needed so far
            res = Math.max(res, count);
        }
        
        return res;
    }
}

// start -> 0 , 5,     15
// end ->          10,    20, 30   