class Solution {
    public int[] sortedSquares(int[] nums) {
        int start=0,rear=nums.length-1;
        int res[]= new int[nums.length];
        int i=rear;
        while(start<rear){
             if(Math.abs(nums[start])>Math.abs(nums[rear])){
                 res[i]=nums[start]*nums[start];
                 start++;
             }else{
                 res[i]=nums[rear]*nums[rear];
                 rear--;
            }
            i--;
        }
        res[i]=nums[rear]*nums[rear];
        return res;
    }
}