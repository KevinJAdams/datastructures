package linkedlist;

public class LinkedList<T> {
    public class Node {
        Node nextNode = null;
        T value;

        public Node(Node nextNode, T value) {
            this.nextNode = nextNode;
            this.value = value;
        }
        public T getValue() {
            return value;
        }
        public Node next() {
            return nextNode;
        }
        public void setNext(Node node) {
            this.nextNode = node;
        }
    }


    Node head;
    Node tail;

    public void append(T value) {
        Node node = new Node(null, value);
        if (tail == null) {
            tail = node;
            head = node;
        } else {
            tail.setNext(node);
            tail = node;
        }
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }
    public Node createNode(Node next, T value) {
        return new Node(next, value);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Node node = head; node != null; node = node.next()) {
            result.append(node.getValue() + "; ");
        }
        return result.toString();
    }

}
