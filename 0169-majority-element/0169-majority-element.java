class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for(int i:nums){
            if(set.contains(i)){
                map.put(i,map.get(i)+1);
            }else{
                map.put(i,1);
            }
            set.add(i);
        }
        int n = nums.length, max=0, elm=nums[0];
        for(Integer i:set){
            int count = map.get(i);
            if(count>n/2){
                if(count>max){
                    max = count;
                    elm = i;
                }
            }
        }
        return elm;
    }
}