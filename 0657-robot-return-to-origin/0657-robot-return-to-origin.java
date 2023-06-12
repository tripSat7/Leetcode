class Solution {
    public boolean judgeCircle(String moves) {
        // char ch[] = moves.toCharArray();
        int hor=0,ver=0;
        for(int i=0;i<moves.length();i++){
            if(moves.charAt(i)=='U'){
                ver++;
            }else if(moves.charAt(i)=='D'){
                ver--;
            }else if(moves.charAt(i)=='L'){
                hor++;
            }else{
                hor--;
            }
        }
        return hor==0&&ver==0;
    }
}