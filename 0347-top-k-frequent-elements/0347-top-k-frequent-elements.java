class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans[] = new int[k];

        for(int i : nums){
            map.put(i, map.getOrDefault(i,0)+1);
        }
        
        List<Integer> bucket[] = new ArrayList[nums.length+1];
        
        for(int i : map.keySet()){
            int freq = map.get(i);
            if(bucket[freq] == null){
                bucket[freq] =  new ArrayList<>();
            }
            bucket[freq].add(i);
        }
        
        List<Integer> res = new ArrayList<>();
        for(int i = bucket.length - 1; i > 0  && k > 0; i--){
            if(bucket[i] != null){
                res.addAll(bucket[i]);
                k = k - bucket[i].size();
            }
        }
        for(int i = 0; i < res.size(); i++){
            ans[i] = res.get(i);
        }
        
        return ans;
    }
}