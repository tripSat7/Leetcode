class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int sum = 0;
        int i = 0;
        int j = 0;
        int res = 0;
        while(j < arr.length)
        {
            sum += arr[j];
            if(j - i + 1 < k)
            {
                j++;
            }
            else if(j - i + 1 == k)
            {
                int avg = sum/k;
                if(avg >= threshold)
                {
                    res++;
                }
                sum -= arr[i];
                i++;
                j++;
            }
        }
        return res;
    }
}