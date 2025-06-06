class Solution {
    public String reorganizeString(String s) {
        char freq[] = new char[26];
        
        int max = 0, letter = 0;
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            freq[ch - 'a']++;
            if(freq[ch - 'a'] > max) {
                max = freq[ch - 'a'];
                letter = ch - 'a';
            }
        }
        
        if(max > ((s.length() + 1)/2)){
            return "";
        }
        
        char res[] = new char[s.length()];
        int idx = 0;
        while(freq[letter] > 0){
            res[idx] = (char) (letter + 'a');
            idx+=2;
            freq[letter]--;
        }
        
        for(int i = 0; i < freq.length; i++) {
            while(freq[i] > 0) {
                if(idx >= res.length) {
                    idx = 1;
                }
                res[idx] = (char) (i + 'a');
                idx += 2;
                freq[i]--;
            }
        }
        
        return String.valueOf(res);
    }
}