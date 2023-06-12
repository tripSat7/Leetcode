class Solution {
    public boolean judgeCircle(String moves) {
        int hor=0,ver=0;
        for(char ch:moves.toCharArray()){
            if(ch=='U'){
                ver++;
            }else if(ch=='D'){
                ver--;
            }else if(ch=='L'){
                hor++;
            }else{
                hor--;
            }
        }
        return hor==0&&ver==0;
    }
}