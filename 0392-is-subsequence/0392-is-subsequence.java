class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s.length()==0){
            return true;
        }
        char ch1[] = s.toCharArray();
        char ch2[] = t.toCharArray();
        int l=0,r=0;
        while(l<ch1.length && r<ch2.length){
            if(ch2[r]==ch1[l]){
                l++;
            }
            r++;
        }
        
        return l==s.length();
    }
}