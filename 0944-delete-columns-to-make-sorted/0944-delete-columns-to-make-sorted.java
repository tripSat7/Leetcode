class Solution {
    public int minDeletionSize(String[] strs) {
        char ch[][] = new char[strs.length][];
        int k=0,count=0;
        for(String s:strs){
            ch[k] = s.toCharArray();
            k++;
        }
        boolean check = true;
        for(int j=0;j<strs[0].length();j++){
            char min = ch[0][j];
            for(int i=0;i<strs.length;i++){
                if(ch[i][j]<min){
                    count++;
                    break;
                }
                min=ch[i][j];
            }
        }
        return count;
    }
}