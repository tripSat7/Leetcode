class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int count=0, sum=0;
        for(int i:timeSeries){
            if(sum<=i){
                count = count + duration;
            }else{
                count = count + (i+duration-sum);
            }
            sum = i + duration;
        }
        return count;
    }
}