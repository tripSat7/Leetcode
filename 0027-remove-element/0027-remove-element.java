class Solution {
    public int removeElement(int[] nums, int val) {
        int front = 0,rear = nums.length-1, counter=0;
        while(front<=rear&&front<nums.length&&rear>=0){
            if(nums[front]==val){
                if(nums[rear]!=val){
                    nums[front]=nums[front]+nums[rear];
                    nums[rear]=nums[front]-nums[rear];
                    nums[front]=nums[front]-nums[rear];
                    front++;rear--;
                }else{
                    rear--;
                }
            }
            else{
                front++;
            }
        }
        return front;
    }
}