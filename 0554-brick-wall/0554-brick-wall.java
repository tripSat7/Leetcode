class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        HashMap<Integer,Integer> map = new HashMap<>();

        for(List<Integer> row : wall){
            int prefix = 0;
            for(int i = 0; i < row.size()-1; i++){

                prefix += row.get(i);
                map.put(prefix, map.getOrDefault(prefix,0) + 1);
            }
        }

        int max = 0;
        for(int num : map.values()){
            max = Math.max(max, num);
        }

        return  wall.size() - max;
    }
}