class Solution {
    public int pivotIndex(int[] nums) {
        for(int i=1;i<nums.length;i++){
            nums[i]=nums[i]+nums[i-1];
        }
        int pivot=-1;
        int l=0;
        int r = nums[(nums.length)-1];
        for(int i=0;i<nums.length;i++){
            if(i!=0){
              l=nums[i-1];  
            }
            
            if(l==(r-nums[i])){
                pivot=i;
                break;
            }
        }
    return pivot;
    }
}