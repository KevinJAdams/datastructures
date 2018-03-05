package queue;

import stack.Stack;

public class QueueOfStacks<T> {
    private Stack stack1;
    private Stack stack2;

    public void add(T value) {
        stack1.push(value);
    }

    public T peek() {
        return null;
    }

    public T remove() {
        return null;
    }

}
