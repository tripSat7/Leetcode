class Solution {
    public boolean judgeCircle(String moves) {
        char ch[] = moves.toCharArray();
        int hor=0,ver=0;
        for(int i=0;i<ch.length;i++){
            if(ch[i]=='U'){
                ver++;
            }else if(ch[i]=='D'){
                ver--;
            }else if(ch[i]=='L'){
                hor++;
            }else{
                hor--;
            }
        }
        return hor==0&&ver==0;
    }
}