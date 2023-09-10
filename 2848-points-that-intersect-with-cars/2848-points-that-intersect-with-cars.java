class Solution {
    public int numberOfPoints(List<List<Integer>> nums) {
        
        HashSet<Integer> res = new HashSet<>();
        
        for(List<Integer> list: nums)
        {
            for(int i = list.get(0); i<=list.get(1);i++)
            {
                res.add(i);
            }
        }  
        return res.size();
    }
}