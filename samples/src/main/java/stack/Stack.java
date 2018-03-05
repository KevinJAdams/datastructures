package stack;

import java.util.Random;

public class Stack<T> {
    private class Node {
        private T value;
        private T minBelow;
        private Node next;
        public Node(T value) {
            this.value = value;
        }


        public Node next() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

    }
    private Node head;
    private int size = 0;

    public T peek() {
        if (head == null) {
            return null;
        }
        return head.getValue();
    }

    public T pop() {
        if (head == null) {
            return null;
        }
        Node node = head;
        head = node.next();
        size--;
        return node.getValue();
    }

    public void push(T value) {
        Node node = new Node(value);
        node.setNext(head);
        head = node;
        size++;
    }

    public T min() {
        if (head == null) {
            return null;
        }
        return head.minBelow;
    }


    public boolean isEmpty() {
        return head == null;
    }

    public int getSize() {
        return size;
    }

    public static Stack<Integer> createRandomStack(int depth, int maxValue) {
        Random random = new Random();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < depth; i++) {
            stack.push(random.nextInt(maxValue));
        }
        return stack;
    }

    public static void sort(Stack<Integer> stack) {
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (Stack<Integer>.Node node = stack.head; node != null; node = node.next()) {
                Stack<Integer>.Node nextNode = node.next();
                if (nextNode != null) {
                    if (node.getValue() > nextNode.getValue()) {
                        swapNodes(node, nextNode);
                        sorted = false;
                    }
                }
            }
        }

    }

    private static void swapNodes(Stack<Integer>.Node node, Stack<Integer>.Node nextNode) {
        int tempValue = node.getValue();
        node.setValue(nextNode.getValue());
        nextNode.setValue(tempValue);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Stack.Node node = head; node != null; node = node.next()) {
            builder.append(node.getValue() + "; ");
        }
        return builder.toString();
    }
}
