class Solution {
    public int largestAltitude(int[] gain) {
        int max=0,alt=0;
        for(int i:gain){
            alt+=i;
            if(alt>max){
                max=alt;
            }
        }
        return max;
    }
}