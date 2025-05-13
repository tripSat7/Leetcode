class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i = 0; i < rocks.length; i++){
            minHeap.add(capacity[i] - rocks[i]);
        }

        int fullCount = 0;
        while (!minHeap.isEmpty()) {
            int need = minHeap.poll();
            if(need <= additionalRocks) {
                additionalRocks -= need;
                fullCount++;
            } 
            else {
                break;
            }
        }

        return fullCount;
    }
}