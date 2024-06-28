class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int i = 0, j = 0;
        int count = 0, res = 0;
        
        while(j < s.length()){
            if(!set.contains(s.charAt(j))){
                count++;
                res = Math.max(count,res);
                set.add(s.charAt(j));
                j++;
            }
            else{
                set.remove(s.charAt(i));
                count--;
                i++;
            }
        }
        
        return res;
    }
}