class Solution {
    public int minSwaps(String s) {
        int ans = 0;
        int extraClosedBracket = 0;
        for(char c: s.toCharArray()) {
            if(c=='[') extraClosedBracket-=1;
            else {
                extraClosedBracket+=1;
                ans = Math.max(ans, extraClosedBracket);
            }
        }
        return (ans+1)/2;
    }
}