class Solution {
    public int maxFrequency(int[] nums, int k) {
        int ks = 0;
        for(int i : nums ){
            if(i == k){
                ks++;
            } 
        }
        int ans = ks;
        for(int x = 1 ; x < 51 ; x++){
            if(k == x){
                continue;
            } 
            int max = 0;
            int curr = 0;
            for(int n : nums){
                if(n == k){
                    curr--;
                }
                if(n == x){
                    curr++;
                } 
                if(curr < 0){
                    curr = 0;
                }   
                max = Math.max(curr, max);
            }
            ans = Math.max(ans, max + ks);
        }
        return ans;
    }
}
