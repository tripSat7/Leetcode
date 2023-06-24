class NumArray {
    
    private int[] pf;
    int sum;
    public NumArray(int[] nums) {
        pf = new int[nums.length];
        sum = pf[0] = nums[0];
        
        for(int i=1;i<pf.length;i++){
            pf[i] = nums[i]+ sum;
            sum = pf[i];
        }
    }
    
    public int sumRange(int left, int right) {
        if(left==0){
            return pf[right];
        }else{
            return pf[right]-pf[left-1];
        }
        
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */