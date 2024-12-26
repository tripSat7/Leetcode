class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        
        int dp[][] = new int[m][n];
        
        for(int i = 0; i < m; i++){
            int sum = 0;
            for(int j = 0; j < n; j++){
                sum += mat[i][j];
                dp[i][j] = sum;
                System.out.print(dp[i][j]+" ");
            }
            //System.out.println();
        }
        
        int ans[][] = new int[m][n];
        for(int i = 0; i < m; i++){
            Arrays.fill(ans[i], 0);
            for(int j = 0; j < n; j++){
                
                int r1 = i-k >= 0 ? i-k: 0, r2 = i+k < m ? i+k: m-1;
                int c1 = j-k >= 0 ? j-k: 0, c2 = j+k < n ? j+k: n-1;
                
                int temp = r1;
                while(temp <= r2){
                    //System.out.println(r1+"||"+c1+"++"+r2+"||"+c2);
                    ans[i][j] += dp[temp][c2];
                    if(c1 - 1 != -1){
                        ans[i][j] -= dp[temp][c1 - 1];
                    }
                    
                    temp++;
                }
                //System.out.println(ans[i][j]+"----");
            }
            //System.out.println();
        }
        
        return ans;
    }
}