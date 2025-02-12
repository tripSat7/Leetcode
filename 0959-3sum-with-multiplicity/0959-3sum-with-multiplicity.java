class Solution {
    public int threeSumMulti(int[] nums, int target) {
        Arrays.sort(nums);
        long output = 0;

        for (int i = 0; i < nums.length - 2; i++) {
            int sum = target - nums[i];
            int j = i + 1, k = nums.length - 1;

            while (j < k) {
                if(nums[j] + nums[k] < sum){
                    j++;
                } 
                else if(nums[j] + nums[k] > sum){
                    k--;
                } 
                else {
                    int count1 = 1, count2 = 1;
                    if (nums[j] == nums[k]) {
                        int len = k - j + 1;
                        output += (len * (len - 1) / 2);
                        break;
                    }

                    while (j < k && nums[j] == nums[j + 1]){
                        count1++; j++; 
                    }

                    while (k > j && nums[k] == nums[k - 1]) {
                        count2++; k--; 
                    }

                    output += count1 * count2;
                    j++; k--;
                }
            }
        }

        return (int) (output % 1000000007);
    }
}