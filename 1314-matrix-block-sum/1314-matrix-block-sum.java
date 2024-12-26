class Solution {
    public int[][] matrixBlockSum(int[][] arr, int k) {
        int m = arr.length;
        int n = arr[0].length;
        int[][] pre = new int[m][n];
        for (int i = 0; i < m; i++) {
            pre[i][0] = arr[i][0];
            for(int j = 1; j < n; j++){
                pre[i][j] = pre[i][j-1] + arr[i][j];
            }
        }
        int[][]ret = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int v = 0;
                int r1 = Math.max(0, i -k);
                int c1 = Math.max(0, j- k);
                int r2 = Math.min(m-1, i + k);
                int c2 = Math.min(n-1, j + k);
                
                for (int r = r1; r <= r2; r++) {
                   v +=  pre[r][c2] - (c1 > 0 ? pre[r][c1-1] : 0) ;
                }
                ret[i][j] = v;
            }
        }
        return ret;
    }
}