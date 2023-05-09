class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int front=0, rear = numbers.length-1;
        while(front<rear){
            if(numbers[front]+numbers[rear]==target){
                return new int[]{front+1,rear+1};
            }
            else if(numbers[front]+numbers[rear]<target){
                front++;
            }else{
                rear--;
            }
        }
        
        return new int[]{front+1,rear-1};
    }
}