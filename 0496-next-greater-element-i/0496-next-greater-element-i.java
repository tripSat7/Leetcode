class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int max=-1;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums2.length;i++){
            map.put(nums2[i],i);
        }
        int j;
        int pf[] = new int[nums2.length];
        for(int i=0;i<nums2.length;i++){
            j=i+1;
            while(j<nums2.length && nums2[j]<nums2[i] ){
                j++;
            }
            
            pf[i] = j==nums2.length?-1:nums2[j];
        }
        
        for(int i=0;i<nums1.length;i++){
            int x = map.get(nums1[i]);
            nums1[i] = pf[x];
        }
        return nums1;
    }
}