class Solution {
    public int percentageLetter(String s, char letter) {
        int ch[] = new int[26];
        for(int i=0;i<s.length();i++){
            ch[s.charAt(i)-'a']+=1;
        }
        float res = (ch[letter-'a']*100)/s.length();
        return (int)res;
    }
}