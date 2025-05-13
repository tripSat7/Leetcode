class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int l = 0, c0 = 0, c1 = 0, ans = 0;

        for(int r = 0; r < answerKey.length(); r++){
            if(answerKey.charAt(r)=='T'){
                c0++;
            }
            else{
                c1++;
            }

            while((Math.min(c0, c1)) > k){
                if(answerKey.charAt(l) == 'T'){
                    c0--;
                }
                else{
                    c1--;
                }
                l++;
            }
            ans = Math.max(ans, r - l + 1);
        }
        
        return ans;
    }
} 