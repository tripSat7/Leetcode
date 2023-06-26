class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        
        int nums[] = new int[1001];
        
        for(int i:nums1){
            nums[i]+=1;
        }
        int count=0;
        for(int i:nums2){
            if(nums[i]>0){
                count++;
                nums[i]=-1;
            }
        }
        
        return nums1.length>nums2.length?populateRes(nums1,nums, count):populateRes(nums2,nums,count);
    }
    
    public static int[] populateRes(int[] arr, int[] num, int count){
        int res[] = new int[count];
        int j=0;
        for(int i=0;i<arr.length && j<count;i++){
            if(num[arr[i]]==-1){
                res[j] = arr[i];
                num[arr[i]]=0;
                j++;
            }
        }
        
        return res;
    }
}