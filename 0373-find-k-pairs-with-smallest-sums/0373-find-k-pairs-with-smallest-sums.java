class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int m = nums2.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->(a[0] - b[0]));
        HashSet<Pair<Integer,Integer>>hashSet = new HashSet<>();
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> pair;
        int i,j;
        pq.add(new int[]{nums1[0]+nums2[0],0,0});
        hashSet.add(new Pair<Integer, Integer>(0, 0));
        while (!pq.isEmpty() && k-->0){
            int [] min = pq.remove();
            i = min[1];
            j = min[2];
            ans.add(Arrays.asList(nums1[i],nums2[j]));
            if(i<n-1 && !hashSet.contains(new Pair<Integer, Integer>(i+1,j))){
                pq.offer(new int[]{nums1[i+1]+nums2[j],i+1,j});
                hashSet.add(new Pair<Integer, Integer>(i+1,j));;
            }

            if(j<m-1 && !hashSet.contains(new Pair<Integer, Integer>(i,j+1))){
                pq.offer(new int[]{nums1[i]+nums2[j+1],i,j+1});
                hashSet.add(new Pair<Integer, Integer>(i,j+1));
            }
        }
        return ans;
    }
}