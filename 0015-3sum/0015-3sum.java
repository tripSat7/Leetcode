class Solution {
    private int[] nums;
    private List<List<Integer>> result;
    private int l;
    
    public List<List<Integer>> threeSum(int[] nums) {
        result = new ArrayList<>();
        l = nums.length;
        Arrays.sort(nums);
        this.nums = nums;

        for (int i = 0; i < l - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] > 0) {
                break;
            }
            twoSum(i);
        }

        return result;
    }

    private void twoSum(int i) {
        int j = i + 1, k = l - 1, sum;

        while (j < k) {
            sum = nums[i] + nums[j] + nums[k];
            if (sum > 0) {
                k--;
                continue;
            }
            if (sum < 0) {
                j++;
                continue;
            }
            result.add(List.of(nums[i], nums[j], nums[k]));
            j++;
            k--;
            while (j < k && nums[j] == nums[j - 1]) {
                j++;
            }
        }
    }
}