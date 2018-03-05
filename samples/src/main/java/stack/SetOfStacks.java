package stack;

public class SetOfStacks<T> {
    private static int MAX_STACK_SIZE = 10;
    private Stack<Stack> stacks;

    public void push(T value) {
        Stack<T> currentStack = stacks.peek();
        if (currentStack == null || currentStack.getSize() >= MAX_STACK_SIZE) {
            currentStack = new Stack();
            stacks.push(currentStack);
        }
        currentStack.push(value);
    }

    public T peek() {
        Stack<T> currentStack = stacks.peek();
        return currentStack.peek();
    }

    public T pop() {
        Stack<T> currentStack = stacks.peek();
        T result = currentStack.pop();
        if (currentStack.isEmpty()) {
            stacks.pop();
        }
        return result;
    }

    public boolean isEmpty() {
        return stacks.isEmpty();
    }
}
