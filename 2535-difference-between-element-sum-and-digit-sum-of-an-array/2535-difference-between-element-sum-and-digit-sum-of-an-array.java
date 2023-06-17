class Solution {
    public int differenceOfSum(int[] nums) {
        int elm=0,dig=0;
        for(int i=0;i<nums.length;i++){
            elm+=nums[i];
            dig+=findElementSum(nums[i]);
        }
        
        return Math.abs(elm-dig);
    }
    
    public static int findElementSum(int n){
        int sum=0;
        while(n!=0){
            int rem = n%10;
            sum+=rem;
            n=n/10;
        }
        return sum;
    }
}