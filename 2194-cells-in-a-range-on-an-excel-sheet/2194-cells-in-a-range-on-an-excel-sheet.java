class Solution {
    public List<String> cellsInRange(String s) {
        List<String> res = new ArrayList<String>();
        
        for(char c = s.charAt(0);c<=s.charAt(3);c++){
            for(int j=s.charAt(1)-'0';j<=s.charAt(4)-'0';j++){
                res.add(""+c+j);
            }
        }
        return res;
    }
}