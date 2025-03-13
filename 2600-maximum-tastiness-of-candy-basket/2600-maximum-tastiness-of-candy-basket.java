class Solution {
    public int maximumTastiness(int[] price, int k) {
        Arrays.sort(price);
        int left = 0, right = Integer.MAX_VALUE;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canDo(price, k, mid)) {
                left = mid + 1;
            } 
            else{
                right = mid;
            }
        }

        return right - 1;
    }

    
    public boolean canDo(int[] p, int k, int minDiff) {
        int total = 1;
        int prev = p[0];
        for (int i = 1; i < p.length; i++) {
            if (p[i] - prev >= minDiff) {
                total++;
                prev = p[i];
            } 
        }
        return total >= k;
    }
}