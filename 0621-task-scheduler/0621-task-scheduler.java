class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char task : tasks) {
            freq[task - 'A']++;
        }
        
        Arrays.sort(freq);
        int chunk = freq[25] - 1;
        int idle_spots = chunk * n;

        for (int i = 24; i >= 0; i--) {
            idle_spots -= Math.min(chunk, freq[i]);
        }

        return idle_spots < 0 ? tasks.length : tasks.length + idle_spots;
    }
}