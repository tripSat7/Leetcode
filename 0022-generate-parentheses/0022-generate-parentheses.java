// Time Complexity: O(2^2n) in worst case
// Space Complexity: O(n) 
class Solution {
    
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        generation(res, new StringBuilder(), n, n);
        return res;
    }
    
    public void generation(List<String> res, StringBuilder s, int left, int right){
        // Base case: no more brackets to add
        if(left == 0 && right == 0){
            res.add(s.toString());
            return;
        }
        
        // Add '(' if any are left
        if(left > 0){
            int len = s.length(); // Save current length to backtrack
            generation(res, s.append("("), left-1, right);
            s.setLength(len); // Backtrack: restore previous state
        }

        //Add ')' only if it won't unbalance the string
        if(left < right){
            int len = s.length();
            generation(res, s.append(")"), left, right-1);
            s.setLength(len);
        }
    }
}