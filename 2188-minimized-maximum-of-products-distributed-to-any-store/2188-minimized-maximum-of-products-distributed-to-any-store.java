class Solution {
    public int minimizedMaximum(int n, int[] arr) {
        int left = 1, right = arr[0];

        for(int i : arr){
            right = Math.max(i, right);
        }

        int res = 0;
        while(left <= right){
            int mid = left + (right - left)/2;
            // System.out.println(left+"||"+right);
            if(helper(arr, n , mid)){
                res = mid;
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }

        return res;
    }

    public boolean helper(int[] arr, int n, int mid){
        int count = 0;

        for(int i : arr){
            count += ((i + mid - 1)/mid);
        }

        return count <= n;
    }
}