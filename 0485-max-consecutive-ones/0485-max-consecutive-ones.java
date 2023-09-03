class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
         int counter=0;
        int maxCount=0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]==1){
                counter++;
            }
            else{
                maxCount = Math.max(counter,maxCount);
                counter = 0;
            }
        }
       
        return  Math.max(counter,maxCount);
    }
}