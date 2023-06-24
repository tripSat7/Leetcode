class Solution {
    public int maxProfit(int[] prices) {
        int low= Integer.MAX_VALUE;
        int res = 0;
        int curProf = 0;
        
        for(int i: prices){
            if(i<low){
                low = i;
            }
            
            curProf = i - low;
            if(curProf>res){
                res = curProf;
            }
        }
        return res;
    }
}