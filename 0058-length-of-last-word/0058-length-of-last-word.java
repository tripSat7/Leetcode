class Solution {
    public int lengthOfLastWord(String s) {
        char ch[] = s.toCharArray();
        int count=0;
        for(int i=ch.length-1;i>=0;i--){
            if(count!=0 && ch[i]==' '){
                break;
            }
            if(ch[i]!=' '){
                count++;
            }
        }
        return count;
    }
}