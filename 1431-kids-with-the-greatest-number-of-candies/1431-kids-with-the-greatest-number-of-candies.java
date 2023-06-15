class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max=0;
        for(int n:candies){
            if(n>=max){
                max=n;
            }
        }
        List<Boolean> list = new ArrayList<Boolean>();
        
        for(int n:candies){
            if(n+extraCandies>=max){
                list.add(true);
            }else{
                list.add(false);
            }
        }
        
        return list;
    }
}