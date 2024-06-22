class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (List<Integer> row : wall) {
            int end = 0;
            for (int i = 0; i < row.size() - 1; i++) {
                end += row.get(i);
                freq.put(end, freq.getOrDefault(end, 0) + 1);
            }
        }
        
        if (freq.isEmpty()) {
            return wall.size();
        }
        
        int max = 0;
        for (Integer val : freq.values()) {
            if (val > max){
                max = val;
            } 
        }

        return (wall.size() - max);
    }
}