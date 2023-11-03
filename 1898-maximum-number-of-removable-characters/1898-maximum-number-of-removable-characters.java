class Solution {
    public int maximumRemovals(String s, String p, int[] removable) {
        
        int left = 0, right = removable.length-1;
        
        while(left <= right){
            int mid = left + (right-left)/2;
            char ch[] = s.toCharArray();    
            for(int i = 0; i <= mid; i++)
            {
                ch[removable[i]] = '|';
            }
            
            if(isSubsequence(ch, p)){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        
        return right+1;
    }
    
    
    public boolean isSubsequence(char ch1[], String p){
        char ch2[] = p.toCharArray();
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