class MinStack {
    private Stack<int[]> stack = new Stack<>();

    public MinStack() {}

    public void push(int x) {
        /* If the stack is empty, then the min value
        must just be the first value we add. */
        if (stack.isEmpty()) {
            stack.push(new int[] { x, x });
            return;
        }

        int currentMin = stack.peek()[1];
        stack.push(new int[] { x, Math.min(x, currentMin) });
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek()[0];
    }

    public int getMin() {
        return stack.peek()[1];
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