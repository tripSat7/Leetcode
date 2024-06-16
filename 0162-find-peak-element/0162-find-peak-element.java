class Solution {
    public int findPeakElement(int[] arr) {
        
        int low = 0, high = arr.length - 1;
        
        while(low < high){
            int mid = low + (high-low)/2;
            //System.out.println(mid);
            if(mid > 0 && arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1]){
                return mid;
            }
            else if(arr[mid + 1] > arr[mid]){
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        
        return low;
    }
}