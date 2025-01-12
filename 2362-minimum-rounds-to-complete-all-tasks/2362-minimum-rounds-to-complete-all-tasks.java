class Solution {
    public int minimumRounds(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i : nums){
            map.put(i, map.getOrDefault(i, 0)+1);
        }

        int res = 0;

        for (int c: map.values()) {
            if (c == 1) {
                return -1;
            }
            res += Math.ceil((double) c / 3);
        }

        return res; 
    }
}