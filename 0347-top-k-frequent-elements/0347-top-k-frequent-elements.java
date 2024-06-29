class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        if(k == nums.length){
            return nums;   
        }

        int res[] = new int[k];
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int n: nums){
            map.put(n, map.getOrDefault(n, 0)+1);
        }
            
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> map.get(b) - map.get(a));

        for(int i : map.keySet()){
            pq.offer(i);   
        }

        for(int i = 0; i < k; i++){
            res[i] = pq.poll();   
        }

        return res;
    }
}