class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int max = 0;

        for(List<Integer> row : wall){
            int prefix = 0;
            for(int i : row){
                prefix += i;
                map.put(prefix, map.getOrDefault(prefix,0)+1);
                max = Math.max(prefix, max);
            }
        }

        if(map.size() == 1){
            return wall.size();
        }
        map.remove(max);
        int res = 0;
        for(Integer k : map.keySet()){
            res = Math.max(res, map.get(k));
        }

        System.out.println(map);
        return wall.size() - res;
    }
}