class Solution {
    public List<String> cellsInRange(String s) {
        List<String> res = new ArrayList<String>();
        char cs=s.charAt(0),ce=s.charAt(3);
        int rs=s.charAt(1)-'0',re=s.charAt(4)-'0';
        
        for(char c=cs;c<=ce;c++){
            for(int r=rs;r<=re;r++){
                res.add(c+String.valueOf(r));
            }
        }
        return res;
    }
}