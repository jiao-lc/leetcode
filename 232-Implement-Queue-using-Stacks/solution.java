class MyQueue {
    Stack<Integer> stack1 = new Stack<Integer>();

    // Push element x to the back of queue.
    public void push(int x) {
        Stack<Integer> tempStack = new Stack<Integer>();
        if(stack1.empty()) stack1.push(x);
        else{
            while(!stack1.empty()){
                tempStack.push(stack1.pop());
            }
            stack1.push(x);
            while(!tempStack.empty()){
                stack1.push(tempStack.pop());
            }
        }
    }

    // Removes the element from in front of queue.
    public void pop() {
        stack1.pop();
    }

    // Get the front element.
    public int peek() {
        return stack1.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return stack1.empty();
    }
}