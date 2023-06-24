class NumArray {
    
    public int pf[];
    public NumArray(int[] nums) {
        this.pf = nums;
        int sum= pf[0];
        for(int i=1;i<nums.length;i++){
            pf[i] = pf[i]+ sum;
            sum = pf[i];
        }
    }
    
    public int sumRange(int left, int right) {
        if(left==0){
            return pf[right];
        }
        return pf[right]-pf[left-1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */