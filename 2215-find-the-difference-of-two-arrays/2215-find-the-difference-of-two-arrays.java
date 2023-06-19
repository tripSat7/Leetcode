class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<Integer> list1 = new ArrayList<Integer>();
        List<Integer> list2 = new ArrayList<Integer>();
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for(int i:nums1){
            if(!list1.contains(i)){
                list1.add(i);
            }
        }
        for(int i:nums2){
            if(!list2.contains(i)){
                list2.add(i);
            }
        }
        
        for(int i:nums1){
            if(list2.contains(i)){
                list1.remove(Integer.valueOf(i));
                list2.remove(Integer.valueOf(i));
            }
        }
        res.add(list1);
        res.add(list2);
        
        return res;
    }
}