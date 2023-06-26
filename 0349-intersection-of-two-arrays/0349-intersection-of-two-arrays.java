class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> arraySet = new HashSet<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int low=0, high=nums1.length-1, mid, x=0;
        while(high>=low && (x<nums2.length))
        {
            mid = low+(high-low)/2;
            if(nums1[mid]<nums2[x]){
                low=mid+1;
            }else if(nums1[mid]>nums2[x]){
                high = mid-1;
            }else{
                arraySet.add(nums2[x]);
                x++; low = 0; high =nums1.length-1;
            }
            //resetting low/high value when element is not found
            if(low>high && x<nums2.length){
                low = 0; high = nums1.length-1;
                x++;
            }
        }
        //transferring arraylist elements to an array
        int result[] = new int[arraySet.size()];
        int i=0;
        for(int res:arraySet){
            result[i++] = res;
        }

        return result;
    }
}