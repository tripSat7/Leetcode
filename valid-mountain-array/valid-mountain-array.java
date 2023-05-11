class Solution {
    public boolean validMountainArray(int[] arr) {
        if(arr.length<3){
            return false;
        }
        
        int front=0, rear=arr.length-1;
        while(front<rear && arr[front]<arr[front+1]){
            front++;
        }
        while(rear>0 && arr[rear]<arr[rear-1]){
            rear--;
        }
        
        if(front==rear&&front>0&&rear<arr.length-1){
            return true;
        }
        return false;
        
    }
}