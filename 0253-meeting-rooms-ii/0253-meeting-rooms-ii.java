// TC : O(n*logn)
// SC : O(n)

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        // Sort intervals by start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        // Min-heap to track the end times of ongoing meetings
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < intervals.length; i++) {
            // If the current meeting starts after the earliest ended meeting,
            // reuse that room by removing it from the heap
            if (!pq.isEmpty() && pq.peek() <= intervals[i][0]) {
                pq.poll();
            }

            // Add the current meeting's end time to the heap
            pq.offer(intervals[i][1]);
        }

        // The size of the heap tells us the minimum number of rooms required
        return pq.size();
    }
}
