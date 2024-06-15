class Solution {
    public int characterReplacement(String s, int k) {
        int[] arr = new int[26];
        int largestCount = 0, beg = 0, maxlen = 0;
        char[] ans = s.toCharArray();
        
        for(int end = 0; end < ans.length; end ++){
            arr[ans[end] - 'A']++;
            largestCount = Math.max(largestCount, arr[ans[end] - 'A']);
            while(end - beg + 1 - largestCount > k){
                arr[ans[beg] - 'A']--;
                beg ++;
            }
        }
        
        return s.length() - beg;
    }
}