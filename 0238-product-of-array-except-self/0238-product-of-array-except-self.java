class Solution {
    public int[] productExceptSelf(int[] nums) {
        int prod=1, flag=0, count=0;
        for(int i:nums){
            if(i!=0){
               prod *= i; 
            }else{
                flag=1;
                count++;
            }
        }
        System.out.println(count);
        if(count>1){
            return new int[nums.length];
        }
        for(int i=0; i<nums.length; i++){
            if(flag==1){
                if(nums[i]!=0){
                    nums[i]=0;
                }else{
                    nums[i] = prod;
                }
            }else{
                nums[i] = prod/nums[i];
            }
        }
        
        return nums;
    }
}