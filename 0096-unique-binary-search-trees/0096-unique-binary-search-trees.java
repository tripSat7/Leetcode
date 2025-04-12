
class Solution {
    int dp[] = new int[20];
    public int numTrees(int i) {

        if(i == 0 || i == 1){
            return 1;
        }
        if(dp[i] != 0){
            return dp[i];
        }


        int sum = 0;
        for(int j = 1; j <= i; j++){
            sum = sum +  numTrees(j-1) * numTrees(i-j);
        }

        dp[i] = sum;
        return sum;
    }
}