class Solution {
    public List<String> cellsInRange(String s) {
        char[] str = s.toCharArray();
        List<String> result = new ArrayList<>();
        
        for (char c1 = str[0]; c1 <= str[3]; c1++) {
            for (char c2 = str[1]; c2 <= str[4]; c2++) {
                result.add("" + c1 + c2);
            }
        }
        
        return result;
    }
}