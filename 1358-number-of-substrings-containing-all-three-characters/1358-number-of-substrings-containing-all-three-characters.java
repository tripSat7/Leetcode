class Solution {
    public int numberOfSubstrings(String s) {
        int cnt[] = new int[3];
        int res = 0, st = 0, end = 0;
        int n = s.length();
        while(end < n){
            cnt[s.charAt(end) - 'a']++;
            
            while(cnt[0] > 0 && cnt[1] > 0 && cnt[2] > 0){
                res = res + n - end;
                
                cnt[s.charAt(st) - 'a']--;
                st++;
            }
            end++;
        }
        
        return res;
    }
}