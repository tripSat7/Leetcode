public class Solution {
    public int minSwaps(String s) {
        int close = 0, maxClose = 0;
        for(char ch : s.toCharArray()){
            if (ch == '['){
                close--;
            } 
            else{
                close++;
            } 
            maxClose = Math.max(maxClose, close);
        }

        return (maxClose + 1) / 2;
    }
}