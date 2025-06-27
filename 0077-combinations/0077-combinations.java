class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();

        backtrack(res, new ArrayList<>(), n, k, 0);
        return res; 
    }

    public void backtrack(List<List<Integer>> res, List<Integer> tempList, int n, int k, int start){

        if(tempList.size() == k){
            res.add(new ArrayList<>(tempList));
        }

        for(int i = start; i < n; i++){
            tempList.add(i+1);
            backtrack(res, tempList, n, k, i+1);
            tempList.remove(tempList.size() - 1);
        }
    }
}