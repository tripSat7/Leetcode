class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        // System.out.println((arr[0]^arr[1]^arr[2]));
        int prefix[] = new int[arr.length];
        prefix[0] = arr[0];
        int res[] = new int[queries.length];
        for(int i = 1; i < arr.length; i++){
            prefix[i] = arr[i] ^ prefix[i - 1];
        }
        
        for(int i = 0; i < queries.length; i++){
            int a = queries[i][0];
            int b = queries[i][1];
            
            res[i] = prefix[a] ^ prefix[b] ^ arr[a];
        }
        
        return res;
    }
}