class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
         generate(nums, 0, new ArrayList<>(), res);
         return res;
     }
     public void generate(int[] nums, int i, List<Integer> temp, List<List<Integer>> res) {
         if(i == nums.length) {
            res.add(new ArrayList(temp));
            return;
         }
         generate(nums, i + 1, temp, res);
         temp.add(nums[i]);
         generate(nums, i + 1, temp, res);
         temp.remove(temp.size() - 1);
     }
}