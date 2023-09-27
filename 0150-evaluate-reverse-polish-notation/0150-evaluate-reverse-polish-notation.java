class Solution {
    public int evalRPN(String[] tokens) {
        
        Stack<Integer> stk = new Stack<>();
        for(String i : tokens){
            if(i.equals("+")){
                int t = stk.pop()+stk.pop();
                stk.push(t);
            }
            else if(i.equals("-")){
                int t =(stk.pop()-stk.pop())*(-1);
                stk.push(t);
            }
              else if(i.equals("*")){
                int t =stk.pop()*stk.pop();
                stk.push(t);
            }
             else if(i.equals("/")){
                int x= stk.pop();
                int y =stk.pop();
                stk.push(y/x);
            }
            else{
                int t =  Integer.parseInt(i);
                stk.push(t);
            }
        }
        
        return stk.pop(); 
    }
}