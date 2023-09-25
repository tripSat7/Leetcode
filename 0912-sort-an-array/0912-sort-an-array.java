class Solution {
    public int[] sortArray(int[] nums) {
       int[] counts = new int[100001];
        
        for (int num : nums) {
            counts[num + 50000]++;
        }
        
        int index = 0;
        for (int i = 0; i < counts.length; i++) {
            while (counts[i] > 0) {
                nums[index++] = i - 50000;
                counts[i]--;
            }
        }
        
        return nums;
    }
    
}
