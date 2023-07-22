class Solution {
    public int removeDuplicates(int[] nums) {
        int k=1,read=1, write = 0;
        while(read<nums.length){
            // System.out.println("nums["+write+"]:"+nums[write]+" nums["+read+"]:"+nums[read]+" k="+k);
            if(nums[read]==nums[write]){
                if(k<2){
                    write++;
                    nums[write] = nums[read];
                    k++;
                }
            }
            else{
                k=0;
                write++;
                nums[write] = nums[read];
                k++;
            }        
            read++;
        }
        
        return ++write;
    }
}