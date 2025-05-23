class Solution {
    
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b)->a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < envelopes.length; i++){
            int n = envelopes[i][1];
            if (res.isEmpty() || res.get(res.size() - 1) < n) {
                res.add(n);
            } 
            else {
                int idx = binarySearch(res, n);
                res.set(idx, n);
            }

            //System.out.println(res);
        }


        return res.size();  
    }

    private int binarySearch(List<Integer> arr, int target) {
        int left = 0;
        int right = arr.size() - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr.get(mid) == target) {
                return mid;
            } 
            else if (arr.get(mid) > target) {
                right = mid - 1;
            } 
            else {
                left = mid + 1;
            }
        }

        return left;
    } 
}

/*

2,3
5,4
6,7
6,5
7,6
*/