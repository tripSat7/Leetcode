class Solution {
    public int countAsterisks(String s) {
        int res = 0, counter = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '*' && counter % 2 == 0){
                res++;                
            }
            if (s.charAt(i) == '|'){
                counter++;
            }     
        }
        return res;
    }
}