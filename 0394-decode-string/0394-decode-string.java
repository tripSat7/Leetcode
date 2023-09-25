class Solution {
    public String decodeString(String s) {
        Stack<String> stk = new Stack<>();
        
        for(Character c : s.toCharArray()){
            stk.push(Character.toString(c));
            if(c == ']'){
                stk.pop();
                String rpt = "";
                while(!stk.isEmpty() && !stk.peek().equals("[")){
                    rpt = stk.pop() + rpt;
                }
                stk.pop();
                String num = "";
                while(!stk.isEmpty() && (stk.peek().charAt(0)<='9' && stk.peek().charAt(0)>='0')){
                    num = stk.pop() + num;
                }
                int n = Integer.parseInt(num);
                stk.push(rpt.repeat(n));
            }
        }
        
        String res = "";
        
        while(!stk.isEmpty()){
            res = stk.pop() + res;
        }
        return res;
    }
}