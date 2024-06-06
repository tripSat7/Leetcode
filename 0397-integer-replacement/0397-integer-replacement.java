class Solution {
    HashMap<Integer,Integer> res = new HashMap<>();
    
    public int integerReplacement(int n) {
        
        if(n == 1){
            return 0;
        }
        
        if(n == Integer.MAX_VALUE){
            return 32;
        }
        
        if(!res.containsKey(n)){
            if(n % 2 == 0){
                res.put(n,integerReplacement(n/2));
            }
            else{
                res.put(n, Math.min(integerReplacement(n+1), integerReplacement(n-1)));
            }
        }
        
        return 1 + res.get(n);
    }
}