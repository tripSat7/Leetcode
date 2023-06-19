class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> res = new ArrayList(2);
        List<Integer> list1 = new ArrayList();
        List<Integer> list2 = new ArrayList();
        res.add(list1);
        res.add(list2);

        Set<Integer> s1 = initializeSet(nums1); 
        Set<Integer> s2 = initializeSet(nums2); 

        for(int num: s1){
            if(!s2.contains(num)){
                list1.add(num);
            } 
        } 
            
        for(int num: s2){
            if(!s1.contains(num)){
                list2.add(num);
            } 
        } 
        
        return res;
    }

    private Set initializeSet(int[] nums){
        Set<Integer> s = new HashSet(nums.length); 
        for(int num: nums){
            s.add(num);
        } 
        return s;
    }
}