class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        HashSet<Integer> set1=new HashSet();
        HashSet<Integer> set2=new HashSet();

        for(int i: nums1){
            set1.add(i);
        }

        for(int i:nums2){
            set2.add(i);
        }
        List<List<Integer>> list=new ArrayList<>();

        ArrayList<Integer> l1=new ArrayList<>();
        ArrayList<Integer> l2=new ArrayList<>();

        for(int ele:set2){
            if(!set1.contains(ele)){
              l1.add(ele);
            }
        }
        
        for(int ele:set1){
            if(!set2.contains(ele)){
               l2.add(ele);
            }
        }

        list.add(l2);
        list.add(l1);
        return list;
    }
}
