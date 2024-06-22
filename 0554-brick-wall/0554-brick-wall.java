class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < wall.size(); i++) {
            List<Integer> bricks = wall.get(i);
            int len = 0;
            for (int j = 0; j < bricks.size() -1 ; j++) {
                len += bricks.get(j);
                putToMap(map, len);
            }
        }
        if (map.isEmpty()) {
            return wall.size();
        }
        return wall.size() - Collections.max( map.values());
    }

    private void putToMap(Map<Integer, Integer> map, int val) {
        if (map.containsKey(val)) {
            map.put(val, map.get(val) + 1);
        } else {
            map.put(val, 1);
        }
    }
}