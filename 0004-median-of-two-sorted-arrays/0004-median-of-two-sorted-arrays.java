class Solution {
    public double findMedianSortedArrays(int[] arr, int[] brr) {
        int i = 0, j = 0;
        int count = 0;
        int n = arr.length;
        int m = brr.length;
        int total = (n + m);
        int curr = 0, prev = 0;
        while(count <= total/2){
            prev = curr;
            if(i < n && (j >= m || arr[i] <= brr[j])){
                curr = arr[i];
                i++;
            }
            else{
                curr = brr[j];
                j++;
            }
            //System.out.println(curr+"::"+prev);
            count++;
        }
        
        if(total % 2 == 0){
            double res = ((double) curr+prev)/2; 
            return res;
        }
        else{
            return curr;  
        }
    }
}