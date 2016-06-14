class MyQueue {
    
    Stack<Integer> stack = new Stack<Integer>();
    // Push element x to the back of queue.
    public void push(int x) {
        stack.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        Stack<Integer> tmp = new Stack<Integer>();
        while(!stack.empty())   tmp.push(stack.pop());
        tmp.pop();
        while(!tmp.empty()) stack.push(tmp.pop());
    }

    // Get the front element.
    public int peek() {
        Stack<Integer> tmp = new Stack<Integer>();
        while(!stack.empty())   tmp.push(stack.pop());
        int t = tmp.peek();
        while(!tmp.empty()) stack.push(tmp.pop());
        return t;
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return stack.empty();
    }
}