class Solution {
    public int findDuplicate(int[] nums) {
        boolean count[] = new boolean[nums.length];
        
        for(int i=0; i<nums.length;i++){
            if(count[nums[i]]==true){
                return nums[i];
            }
            else{
                count[nums[i]]=true;
            }
        }
        
        return 0;
    }
}