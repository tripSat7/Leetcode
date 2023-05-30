class Solution {
    public String restoreString(String s, int[] indices) {
        char res[] = new char[indices.length];
        int j=0;
        for(int i:indices){
            res[i]=s.charAt(j++);
        }
        
        return new String(res);
    }
}