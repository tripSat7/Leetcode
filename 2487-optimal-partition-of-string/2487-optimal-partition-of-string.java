class Solution {
    public int partitionString(String s) {
        int i = 0, res = 0;
        while(i < s.length()){
            Set<Character> set = new HashSet<>();
            while(i < s.length() && !set.contains(s.charAt(i))){
                set.add(s.charAt(i));
                i++;
            }
            res++;
        }

        return res;
    }
}