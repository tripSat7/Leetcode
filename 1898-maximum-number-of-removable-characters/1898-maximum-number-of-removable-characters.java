class Solution {
    public int maximumRemovals(String s, String p, int[] removable) {
        
        int left = 0, right = removable.length-1;
        char ch1[] = s.toCharArray();
        char ch2[] = p.toCharArray();
        while(left <= right){
            int mid = left + (right-left)/2;
            for(int i = 0; i <= mid; i++) ch1[removable[i]] = '|';
            
            if(isSubsequence(ch1, ch2)){
                left = mid + 1;
            }
            else{
                for(int i = left; i<= mid; i++){
                    ch1[removable[i]] = s.charAt(removable[i]);
                }
                right = mid - 1;
            }
        }
        
        return right+1;
    }
    
    
    public boolean isSubsequence(char ch1[], char ch2[]){
        
        int sLen = ch1.length, pLen = ch2.length;
        int i = 0, j = 0;
        
        while(i<sLen && j<pLen){
            if(ch1[i] == ch2[j]){
                j++;
            }
            i++;
        }
        
        return j == pLen;
    }
}