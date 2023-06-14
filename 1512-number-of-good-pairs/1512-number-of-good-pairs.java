class Solution {
    public int numIdenticalPairs(int[] nums) {
        Map<Integer,Integer> map= new HashMap<Integer,Integer>();
        for(int n:nums){
            if(map.containsKey(n)){
                map.put(n,map.get(n)+1);
            }else{
                map.put(n,1);
            }
        }
        
        int res=0;
        
        for(int n:nums){
            if(map.get(n)>1){
                int x = map.get(n);
                res= res + (x*(x-1))/2;
                map.put(n,0);
            }
        }
        return res;
    }
}