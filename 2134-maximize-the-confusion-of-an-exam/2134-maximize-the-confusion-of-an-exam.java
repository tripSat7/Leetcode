class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int ans = Math.max(helper(answerKey,k,'T'),helper(answerKey,k,'F'));

        return ans;
    }

    public int helper(String s,int k,char ch){
        int n = s.length();

        int l = 0, r = 0;
        int len = 0;
        int count = 0;

        while(r < n){
            if(s.charAt(r) != ch){
                count++;
            } 

            while(count > k){
                if(s.charAt(l) != ch){
                    count--;
                } 
                l++;
            }

            len = Math.max(len, r - l + 1);
            r++;
        }

        return len;
    }
}