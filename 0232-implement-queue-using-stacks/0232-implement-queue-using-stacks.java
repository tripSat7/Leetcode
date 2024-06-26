class MyQueue {
    Stack<Integer> que;
    
    public MyQueue() {
        que = new Stack<>();
    }
    
    public void push(int x) {
        que.push(x);
    }
    
    public int pop() {
        Stack<Integer> temp = new Stack<>();
        int res = 0;
        while(!que.isEmpty()){
            res = que.pop();
            if(!que.isEmpty()){
                temp.push(res);   
            }
        }
        
        while(!temp.isEmpty()){
            que.push(temp.pop());
        }
        
        return res;
    }
    
    public int peek() {
        Stack<Integer> temp = new Stack<>();
        int res = 0;
        while(!que.isEmpty()){
            res = que.pop();
            temp.push(res);   
        }
        
        while(!temp.isEmpty()){
            que.push(temp.pop());
        }
        
        return res;
    }
    
    public boolean empty() {
        
        return que.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */