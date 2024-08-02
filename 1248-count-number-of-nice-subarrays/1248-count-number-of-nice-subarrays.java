class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return f(nums, k) - f(nums, k-1);
    }

    private int f(int[] arr, int k) {
        int i=0, j=0, odd=0, cnt=0;
        while (j < arr.length) {
            odd += (arr[j]&1);
            while (odd > k) {
                odd -= (arr[i]&1);
                i++;
            }
            cnt += j-i+1;
            j++;
        }
        return cnt;
    }
}