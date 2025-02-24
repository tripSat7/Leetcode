class Solution {
    public int maxStarSum(int[] vals, int[][] edges, int k) {
        int n = vals.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < vals.length; i++){
            adj.add(new ArrayList<>());
        }
        for(int i[] : edges){
            adj.get(i[0]).add(i[1]);
            adj.get(i[1]).add(i[0]);
        }

        int res = Integer.MIN_VALUE;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);

        for(int i = 0; i < n; i++){
            int temp = vals[i];
            for(int j = 0; j < adj.get(i).size(); j++){
                pq.add(vals[adj.get(i).get(j)]);
            }
            int count = k;
            while(count-- > 0 && !pq.isEmpty() && pq.peek() > 0){
                temp += pq.peek();
                pq.remove();
            }

            while(!pq.isEmpty()){
                pq.remove();
            } 
            res = Math.max(res,temp);
        }
        return res;
    }
}