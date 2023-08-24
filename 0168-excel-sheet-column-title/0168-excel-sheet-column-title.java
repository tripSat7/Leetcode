class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder res = new StringBuilder();
        if(columnNumber<27){
            char ch = (char)(64+columnNumber);
            res.append(ch);
            return res.toString();
        }
        else
        {
            while(columnNumber>0){
                columnNumber--;
                char digit=(char)('A'+(columnNumber%26));
                res.append(digit);
                columnNumber/=26;
            }
        }
        return res.reverse().toString();
    }   
}