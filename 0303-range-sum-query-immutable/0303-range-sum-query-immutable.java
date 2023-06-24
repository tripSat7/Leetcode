class NumArray {
    
    public int nums[];
    public NumArray(int[] nums) {
        this.nums = nums;
        int sum= nums[0];
        for(int i=1;i<nums.length;i++){
            nums[i] = nums[i]+ sum;
            sum = nums[i];
        }
    }
    
    public int sumRange(int left, int right) {
        if(left==0){
            return nums[right];
        }
        return nums[right]-nums[left-1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */