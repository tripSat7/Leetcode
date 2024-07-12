class Solution {

    public int maximumGain(String s, int x, int y) {
        int res = 0;
        String hPair = x > y ? "ab" : "ba";
        String lPair = hPair.equals("ab") ? "ba" : "ab";

        String firstPass = removeSubstring(s, hPair);
        int count = (s.length() - firstPass.length()) / 2;

        res += count * Math.max(x, y);
        
        String secondPass = removeSubstring(firstPass,lPair);
        count = (firstPass.length() - secondPass.length()) / 2;

        
        res += count * Math.min(x, y);

        return res;
    }

    private String removeSubstring(String input, String target) {
        Deque<Character> chStk = new ArrayDeque<>();

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            if (ch == target.charAt(1) && !chStk.isEmpty() && chStk.peek() == target.charAt(0)){
                chStk.pop();
            } else {
                chStk.push(ch);
            }
        }

       
        StringBuilder stringAfter = new StringBuilder();
        while (!chStk.isEmpty()) {
            stringAfter.append(chStk.pop());
        }
        
        return stringAfter.reverse().toString();
    }
}