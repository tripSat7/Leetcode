class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<Integer>();
        HashSet<Integer> set = new HashSet<Integer>();
        for(int n:nums){
            set.add(n);
        }
        int count=1;
        for(int n:nums){
            if(!set.contains(count)){
                list.add(count);
            }
            count++;
        }
        return list;
    }
}