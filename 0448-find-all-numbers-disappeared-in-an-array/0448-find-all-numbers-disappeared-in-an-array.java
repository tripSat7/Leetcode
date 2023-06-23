class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        boolean[] n = new boolean[nums.length];
        List<Integer> res = new ArrayList<>();
        
        for (int i: nums) {
            n[i - 1] = true;
        }
        
        for (int i = 0; i < n.length; i++) {
            if (!n[i]) {
                res.add(i + 1);
            }
        }
        return res;
    }
}