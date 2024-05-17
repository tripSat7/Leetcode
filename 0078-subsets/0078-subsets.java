class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int pow_set = 1<<nums.length;
        
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < pow_set; i++){
            List<Integer> temp = new ArrayList<>(); 
            for(int j = 0; j < nums.length; j++){
                if((i & (1<<j)) > 0){
                    temp.add(nums[j]);
                }
            }
            res.add(temp);
            // if(!res.contains(temp)){
            //     res.add(temp);
            // }
        }
        return res;
    }
}