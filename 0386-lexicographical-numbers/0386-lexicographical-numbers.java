class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        for(int i = 1; i <= 9; i++){
            if(i <= n){
                res.add(i);
                helper(res, n, (""+i));
            }
        }
        
        return res; 
    }
    
    public void helper(List<Integer> res, int n, String st){
        
        String end = st + "0";
        if(Integer.parseInt(end) > n){
            return;
        }
        
        for(int i = 0; i <= 9; i++){
            String ex = st+i;
            if(Integer.parseInt(ex) <= n){
                res.add(Integer.parseInt(ex));    
            }
            helper(res, n, ex);
        }
    }
    
}