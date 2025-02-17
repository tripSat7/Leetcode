class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        int sum = 0;
        int k = 0;

        int[] arr = new int[(n*(n+1))/2];

        for(int i = 0; i < n; i++){
            sum=0;
            for(int j = i; j < n; j++)
            {
                sum = sum + nums[j];
                arr[k] = sum;
                k++;
            }
        }
        
        int mod = 1000000007;
        Arrays.sort(arr);
        int ans = 0;
        for(int i = left-1; i < right; i++)
        {
            ans = (ans + arr[i]) % mod;
        }
        return ans;
    }
}