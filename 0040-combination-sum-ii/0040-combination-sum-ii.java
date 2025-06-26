class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates); // Sort to handle duplicates easily
        backtrack(res, new ArrayList<>(), candidates, target, 0, 0);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> tempList, int[] candidates, int target, int start, int sum){
        if(sum == target){
            res.add(new ArrayList<>(tempList));
            return;
        }
        if(sum > target){
            return;
        }
        for(int i = start; i < candidates.length; i++){
            // Skip duplicates: don't pick the same number at the same tree level
            if(i > start && candidates[i] == candidates[i-1]){
                continue;
            } 
            tempList.add(candidates[i]);
            backtrack(res, tempList, candidates, target, i + 1, sum + candidates[i]);
            tempList.remove(tempList.size() - 1);
        }
    }
}
