class Solution {
    public int countAsterisks(String s) {
        boolean count = true;
        int cnt = 0;
        for (char ch: s.toCharArray()){
            if (ch == '|'){
                count = !count;
            }
            if (count && ch == '*'){
                cnt++;
            }
        }
        return cnt;
    }
}