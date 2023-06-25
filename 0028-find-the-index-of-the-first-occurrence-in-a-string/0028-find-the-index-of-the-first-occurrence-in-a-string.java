class Solution {
    public int strStr(String haystack, String needle) {

        int start=0, i;
        char hay[] = haystack.toCharArray();
        char ned[] = needle.toCharArray();
        for(i=0;i<=hay.length-ned.length;i++){
            int t1=i;
            while(t1<hay.length &&  start<ned.length && hay[t1]==ned[start]){
                t1++;start++;
                if(start == ned.length){
                    return t1-start;
                }
            }
            start=0;
        }
        return -1;
    }
}