class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
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
        int c = 0;
        for(int i = bucket.length - 1; i > 0  && k > 0; i--){
            if(bucket[i] != null){
                //List<Integer> list = new ArrayList<>();
                res.addAll(bucket[i]);
                k = k - bucket[i].size();
            }
        }
        
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}