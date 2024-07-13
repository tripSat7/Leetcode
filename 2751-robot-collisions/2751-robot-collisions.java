class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        
        Integer[] idxs = new Integer[positions.length];
        
        for (int i = 0; i < positions.length; i++){
            idxs[i] = i;
        } 
        
        Arrays.sort(idxs, (o1, o2) -> positions[o1] - positions[o2]);

        int[] sortedHealths = new int[idxs.length];
        String sortedDir = "";
        for (int i = 0; i < idxs.length; i++) {
            sortedHealths[i] = healths[idxs[i]];
            sortedDir = sortedDir + directions.charAt(idxs[i]);
        }
        
        List<Integer> res = new ArrayList<>();
        
        Deque<Integer> stack = new ArrayDeque<>();

        for (int currentIndex : idxs) {
            
            if (directions.charAt(currentIndex) == 'R') {
                stack.push(currentIndex);
            } else {
                while (!stack.isEmpty() && healths[currentIndex] > 0) {
                    int topIndex = stack.pop();

                    if (healths[topIndex] > healths[currentIndex]) {
                        healths[topIndex] -= 1;
                        healths[currentIndex] = 0;
                        stack.push(topIndex);
                    } else if (healths[topIndex] < healths[currentIndex]) {
                        
                        healths[currentIndex] -= 1;
                        healths[topIndex] = 0;
                    } else {
                        
                        healths[currentIndex] = 0;
                        healths[topIndex] = 0;
                    }
                }
            }
        }
        
        
        for (int i = 0; i < positions.length; i++) {
            if (healths[i] > 0) {
                res.add(healths[i]);
            }
        }
      
        return res;
    }
}