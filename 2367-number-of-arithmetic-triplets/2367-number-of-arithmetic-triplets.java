class Solution {
    public int arithmeticTriplets(int[] nums, int diff) {
        int count=0;
        Set<Integer> set=new HashSet<>();        
        for(int n:nums){
            if(set.contains(n-diff) && set.contains(n-(2*diff))){
                count++;
            }
            set.add(n);
        }
        return count;
    }
}