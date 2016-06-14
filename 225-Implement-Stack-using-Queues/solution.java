class MyStack {
    Queue<Integer> queue = new LinkedList<Integer>();
    // Push element x onto stack.
    public void push(int x) {
        if(queue.peek() == null)    queue.add(x);
        else {
            Queue<Integer> tmp = new LinkedList<Integer>();
            while(queue.peek() != null) tmp.add(queue.poll());
            queue.add(x);
            while(tmp.peek() != null) queue.add(tmp.poll());
        }
    }

    // Removes the element on top of the stack.
    public void pop() {
        queue.poll();
    }

    // Get the top element.
    public int top() {
        return queue.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queue.peek() == null;
    }
}