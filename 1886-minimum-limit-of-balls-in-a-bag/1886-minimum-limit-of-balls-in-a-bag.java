class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        
        int left = 1;
        int right = 0;

        for(int num : nums) {
            right = Math.max(right, num);
        }

        while(left < right) {
            int middle = (left + right) / 2;

            if(isPossible(middle, nums, maxOperations)) {
                right = middle; 
            } 
            else {
                left = middle + 1; 
            }
        }

        return left;
    }

    private boolean isPossible(int x, int[] nums, int maxOperations) {
        int ops = 0;

        for (int num : nums) {
            ops += (num + x -1)/x - 1;
            
            if (ops > maxOperations) {
                return false;
            }
        }

        return true;
    }
}