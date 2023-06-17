class Solution {
    public int arithmeticTriplets(int[] nums, int diff) {
        int count=0;
        List<Integer> list = new ArrayList<Integer>();
        for(int n:nums){
            list.add(n);
        }
        for(int n:nums){
            if(list.contains(n+diff) && list.contains(n+(2*diff))){
                count++;
            }
        }
        return count;
    }
}