class Solution {
    public boolean squareIsWhite(String coordinates) {
        if((coordinates.charAt(0)-'a'+coordinates.charAt(1)-'0')%2==0){
            return  true;
        }
        return false;
    }
}