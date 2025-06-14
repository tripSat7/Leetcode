class Solution {
    public int maxSumDistinctTriplet(int[] x, int[] y) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < x.length; i++){
            map.put(x[i], Math.max(y[i], map.getOrDefault(x[i], 0) ) );
        }

        if(map.size() < 3){
            return -1;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        for (int val : map.values()) {
            maxHeap.add(val);
        }

        int sum = 0;
        for (int i = 0; i < 3; i++) {
            sum += maxHeap.poll();
        }

        return sum;
    }
}

/* Time complexity
map.values() takes O(m), where m is the number of unique keys .
maxHeap O(log m) per insertion.
 O(m log m)

 Total time complexity = O(n + mlogm)
*/