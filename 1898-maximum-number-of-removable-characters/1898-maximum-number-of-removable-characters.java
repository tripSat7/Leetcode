class Solution {
    public int maximumRemovals(String s, String p, int[] removable) {
        
        int left = 0, right = removable.length-1;
        char ch1[] = s.toCharArray();
        char ch2[] = p.toCharArray();
        while(left <= right){
            int mid = left + (right-left)/2;
            for(int i = left; i <= mid; i++){
                ch1[removable[i]] = '|';
            } 
            
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
                i++;
            }
            else{
                i++;   
            }
        }
        
        return j == pLen;
    }
        
        
//         char[] sArr = s.toCharArray();
//         char[] pArr = p.toCharArray();
//         int start = 0;
//         int end = removable.length-1;
        
//         while(start<=end){
//             int mid = start + (end-start)/2;
//             for(int i=start;i<=mid;i++){
//                 sArr[removable[i]] = '*';
//             }
//             if(isSubSequence(sArr,pArr))
//                 start=mid+1;
//             else{
//                 for(int i=start;i<=mid;i++){
//                 sArr[removable[i]] = s.charAt(removable[i]); 
//             }
//             end = mid-1;
//             } 
//         }
//         return end+1;
        
//     }
//     private boolean isSubSequence(char[] sArr,char[] pArr)
//     {
//         int i=0,j=0;
//         while(i<sArr.length && j<pArr.length){
//             if(sArr[i]==pArr[j]){
//                 i++;
//                 j++;
//             }
//             else i++;
//         }
//         return j==pArr.length;
//     }
}