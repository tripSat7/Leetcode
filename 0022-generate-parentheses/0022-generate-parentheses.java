class Solution {
    
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        generation(res, "", n, n);
        return res;
    }
    
    public void generation(List<String> res, String s, int left, int right){
        if(left == 0 && right == 0){
            res.add(s);
            return;
        }
        
        if(left > 0){
            generation(res, s+"(", left-1, right);
        }
        
        if(left < right){
            generation(res, s+")", left, right-1);
        }
    }
}