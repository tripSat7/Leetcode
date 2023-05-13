class Solution {
    public int thirdMax(int[] nums) {
        Integer max=null,second=null,third=null;
        for (Integer n : nums) {
            if (n.equals(max) || n.equals(second) || n.equals(third)){
                continue;
            } 
            if (max == null || n > max) {
                third=second;
                second=max;
                max=n;
            } else if (second == null || n > second) {
                third=second;
                second=n;
            } else if (third == null || n > third) {
                third = n;
            }
        }
        if(third==null){
            return max;
        }
        
        return third;
    }
}