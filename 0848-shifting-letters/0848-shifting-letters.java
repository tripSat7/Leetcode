class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        int prefix[] = new int[shifts.length];
        prefix[shifts.length - 1] = shifts[shifts.length - 1];
        
        for(int i = shifts.length - 2; i >= 0; i--){
            prefix[i] = (shifts[i] + prefix[i+1])%26;
        }
        
        StringBuilder res = new StringBuilder();
        int i = 0;
        for(char ch : s.toCharArray()){
            int temp = ch - 'a';
            temp = (temp + prefix[i])%26;
            char c = (char)('a' + temp);
            res.append(c);
            //System.out.println(c);
            i++;
        }
        
        return res.toString();
    }
}