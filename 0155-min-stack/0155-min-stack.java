class MinStack {

    Stack<Integer> stk;
    Stack<Integer> minStk;

    public MinStack() {
        stk  = new Stack<>();
        minStk = new Stack<>();
    }
    
    public void push(int val) {
        stk.push(val);
        if(minStk.empty()){
            minStk.push(val);    
        }
        else{
            Stack<Integer> tmp = new Stack<>();
            while(!minStk.empty() && minStk.peek() < val){
                tmp.push(minStk.pop());
            }
            minStk.push(val);
            while(!tmp.empty()){
                minStk.push(tmp.pop());
            }
        }
        
    }
    
    public void pop() {
        int res = stk.pop();
        Stack<Integer> tmp = new Stack<>();
        while(!minStk.empty() && minStk.peek() != res){
            tmp.push(minStk.pop());
        }
        minStk.pop();
        while(!tmp.empty()){
            minStk.push(tmp.pop());
        }
    }
    
    public int top() {
        
        return stk.peek();
    }
    
    public int getMin() {
        
        return minStk.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */