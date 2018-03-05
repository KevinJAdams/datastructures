package queue;

public class Queue<T> {
    private class Node {
        public Node(T value) {
            this.value = value;
        }

        private T value;
        private Node nextNode;
        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Node next() {
            return nextNode;
        }

        public void setNext(Node nextNode) {
            this.nextNode = nextNode;
        }
   }
   private Node first;
    private Node last;

    public Queue() {
        first =  null;
        last = null;
    }
    public void add(T value) {
        Node node = new Node(value);
        if (last == null) {
            first = node;
            last = node;
        } else {
            last.setNext(node);
        }

    }

    public T peek() {
        return first.getValue();
    }

    public T remove() {
        Node node = first;
        if (first != null) {
            first = first.next();
        }
        return node.getValue();
    }

    public boolean isEmpty() {
        return (first == null);
    }
}
