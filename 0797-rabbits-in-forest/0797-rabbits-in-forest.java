class Solution {
    public int numRabbits(int[] answers) {
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for(int other : answers){
            map.put(other, map.getOrDefault(other, 0) + 1);

			int count = map.get(other);
			// case 1: all the rabits are found
            if(count == other + 1) {
                sum += count;
                map.remove(other);
            }
        }
        
		// case 2: only subset of rabits in the same color found in the sample
        for(int other : map.keySet()){
            sum += other + 1;
        } 
        
        return sum;
    }
}