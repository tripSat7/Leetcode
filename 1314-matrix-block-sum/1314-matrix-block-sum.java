class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] prefix = new int[m+1][n+1];
        for (int i = 0; i < m; i++) {
            int curSumRow = 0;
            for (int j = 0; j < n; j++) {
                curSumRow += mat[i][j];
                if (i > 0) {
                    prefix[i+1][j+1] = curSumRow + prefix[i][j+1];
                } else {
                    prefix[i+1][j+1] = curSumRow;
                }
            }
        }
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int xLeft = Math.max(i-k, 0);
                int yLeft = Math.max(j-k, 0);
                int xRight = Math.min(i+1+k, m);
                int yRight = Math.min(j+1+k, n);
                res[i][j] = prefix[xRight][yRight] + prefix[xLeft][yLeft] - prefix[xLeft][yRight] - prefix[xRight][yLeft];
            }
        }
        
        return res;
    }
}