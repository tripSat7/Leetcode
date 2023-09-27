class Solution {
    public int evalRPN(String[] tokens) {
        
        Stack<String> stk = new Stack<>();
        
        for(String ch : tokens){
            int num1, num2;
            switch(ch){
                case "+" :  num1 = Integer.valueOf(stk.pop());
                            num2 = Integer.valueOf(stk.pop());
                            stk.push(String.valueOf(num1+num2));
                            break;
                case "-" :  num1 = Integer.valueOf(stk.pop());
                            num2 = Integer.valueOf(stk.pop());
                            stk.push(String.valueOf(num2-num1));
                            break;
                case "*" :  num1 = Integer.valueOf(stk.pop());
                            num2 = Integer.valueOf(stk.pop());
                            stk.push(String.valueOf(num1*num2));
                            break;
                case "/" :  num1 = Integer.valueOf(stk.pop());
                            num2 = Integer.valueOf(stk.pop());
                            stk.push(String.valueOf(num2/num1));
                            break;
                default :   stk.push(ch);
                            break;
                    
            }
        }
        
        return Integer.valueOf(stk.pop());
    }
}