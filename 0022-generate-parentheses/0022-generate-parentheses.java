class Solution {
    
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        generation(res, new StringBuilder(), n, n);
        return res;
    }
    
    public void generation(List<String> res, StringBuilder s, int left, int right){
        if(left == 0 && right == 0){
            res.add(s.toString());
            return;
        }
        
        if(left > 0){
            int len = s.length();
            generation(res, s.append("("), left-1, right);
            s.setLength(len);
        }
        
        if(left < right){
            int len = s.length();
            generation(res, s.append(")"), left, right-1);
            s.setLength(len);
        }
    }
}