class Solution {
    public String frequencySort(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(char ch : s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        
        PriorityQueue<Character> pq = new PriorityQueue<>((a,b)->map.get(b)-map.get(a));
        
        for(char ch : map.keySet()){
            pq.offer(ch);
        }
        
        StringBuilder sb = new StringBuilder();
        int k = pq.size();
        for(int i = 0; i < k; i++){
            char ch = pq.poll();
            int n = map.get(ch);
            for(int j = 0; j < n; j++){
                sb.append(ch);
            }
        }
        
        return sb.toString();
    }
}