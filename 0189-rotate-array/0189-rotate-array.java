class Solution {
    public void rotate(int[] nums, int k) {
        
        k = k % nums.length;
        
        rotatePart(nums, nums.length - k, nums.length -1);
        rotatePart(nums, 0, nums.length - k - 1);
        rotatePart(nums, 0, nums.length - 1);
    }
    
    public void rotatePart(int[] arr, int i, int j){
        
        while(i < j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++; j--;
        }
    }
}