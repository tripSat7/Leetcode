class Solution {
    public int minimizedStringLength(String s) {
        Set<Character> set = new HashSet<Character>();
        String res="";
        for(char c:s.toCharArray()){
            if(!set.contains(c)){
                set.add(c);
                res+=c;
            }
        }
        return res.length();
    }
}