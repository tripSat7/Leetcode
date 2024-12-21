class Solution {
    public boolean isMonotonic(int[] nums) {
        
        if(nums.length <= 2){
            return true;
        }
        
        boolean inc = false, dec = false;
        
        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i+1] > nums[i]){
                inc = true;
            }
            else if(nums[i+1] < nums[i]){
                dec = true;
            }
            
            //System.out.println(inc+"||"+dec);
            if (inc && dec) {
                return false;
            }
        }
        
        return true;
    }
}