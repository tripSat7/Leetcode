class Solution {
    public void sortColors(int[] nums) {
        int count[] = new int[3];
        for(int i:nums){
            count[i]++;
        }
        int i=0;
        for(int k=0; k<3; k++){
            while(count[k]>0 && i<nums.length){
                nums[i] = k;
                count[k]--;
                i++;
            }
        }
    }
}