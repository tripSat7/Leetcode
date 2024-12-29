class Solution {
    public int countPalindromicSubsequence(String s) {
        int[] first = new int[26];
        int[] last = new int[26];
        Arrays.fill(first, -1);
        
        for (int i = 0; i < s.length(); i++) {
            int curr = s.charAt(i) - 'a';
            if (first[curr] == - 1) {
                first[curr] = i;
            }
            
            last[curr] = i;
        }
        
        int res = 0;
        for (int i = 0; i < 26; i++) {
            if (first[i] == -1) {
                continue;
            }
            
            int[] arr = new int[26];
            for (int j = first[i] + 1; j < last[i]; j++) {
                if(arr[s.charAt(j)-'a']++ == 0){
                    res++;
                } 
            }
        }
        
        return res;
    }
}