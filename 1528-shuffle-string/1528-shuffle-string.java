class Solution {
    public String restoreString(String s, int[] indices) {
        StringBuilder res = new StringBuilder(s);
        int j=0;
        for(int i:indices){
            res.setCharAt(i,s.charAt(j++));
            // j++;
        }
        
        return res.toString();
    }
}