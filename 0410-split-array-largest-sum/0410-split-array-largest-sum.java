class Solution {
    public int splitArray(int[] nums, int k) {
        if(nums.length<k){
            return -1;
        }
        int low=Integer.MIN_VALUE;
        int high=0;
        for(int i:nums){
            low=Math.max(low,i);
            high+=i;
        }
        while(low<=high){
            int mid=low+(high-low)/2;
            int x=func(nums,mid);
            if(x>k){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return low;
    }
    public static int func(int[] arr,int mid){
        int x=1;
        int a=0;
        for(int i:arr){
            if(i+a<=mid){
                a+=i;
            }
            else{
                x++;
                a=i;
            }
        }
        return x;
    }
}