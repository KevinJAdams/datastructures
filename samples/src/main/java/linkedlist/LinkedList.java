package linkedlist;

import javafx.util.Pair;

import java.util.Random;
import java.util.Stack;

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

    static LinkedList<Integer> initializeRandomList(int listLength, int maxValue) {
        Random rand = new Random();
        int length = rand.nextInt(listLength) +1;
        LinkedList<Integer> result = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            result.append(rand.nextInt(maxValue));
        }
        return result;
    }

    static LinkedList<Character> initializeFromString(String str) {
        LinkedList<Character> result = new LinkedList<>();
        char[] charArray = str.toCharArray();
        for (char c : charArray) {
            result.append(c);
        }
        return result;
    }

    public static LinkedList<Integer> sum(LinkedList<Integer> first, LinkedList<Integer> second) {
        LinkedList<Integer> result = new LinkedList<>();
        int carryover = 0;
        LinkedList<Integer>.Node node1 = first.getHead();
        LinkedList<Integer>.Node node2 = second.getHead();
        while (node1!= null || node2 != null) {
            int value1 = 0;
            if (node1 != null) {
                value1 = node1.getValue().intValue();
            }
            int value2 = 0;
            if (node2 != null) {
                value2 = node2.getValue().intValue();
            }
            int digit = value1 + value2 + carryover;
            if (digit > 9) {
                carryover = 1;
                digit -= 10;
            } else {
                carryover = 0;
            }
            result.append(digit);
            if (node1 != null) {
                node1 = node1.next();
            }
            if (node2 != null) {
                node2 = node2.next();
            }
        }
        if (carryover > 0) {
            result.append(carryover);
        }
        return result;
    }

    public static LinkedList<Integer> sumReverse(LinkedList<Integer> firstList,
                                                 LinkedList<Integer> secondList) {
        LinkedList<Integer> resultList = new LinkedList<>();
        Stack<Integer> firstStack = new Stack<>();
        Stack<Integer> secondStack = new Stack<>();

        for (LinkedList<Integer>.Node node = firstList.getHead(); node != null; node = node.next()) {
            firstStack.push(node.getValue());
        }
        for (LinkedList<Integer>.Node node = secondList.getHead(); node != null; node = node.next()) {
            secondStack.push(node.getValue());
        }

        LinkedList<Integer>.Node resultHead = null;
        int carryover = 0;
        while (!firstStack.empty() || !secondStack.empty()) {
            int firstValue = 0;
            int secondValue = 0;
            if (!firstStack.empty()) {
                firstValue = firstStack.pop().intValue();
            }
            if (!secondStack.empty()) {
                secondValue = secondStack.pop().intValue();
            }
            int resultValue = firstValue + secondValue + carryover;
            if (resultValue > 9) {
                carryover = 1;
                resultValue -= 10;
            } else {
                carryover = 0;
            }
            LinkedList<Integer>.Node node = resultList.createNode(resultHead, resultValue);
            resultHead = node;
        }
        if (carryover > 0) {
            LinkedList<Integer>.Node node = resultList.createNode(resultHead, carryover);
            resultHead = node;
        }
        resultList.setHead(resultHead);
        return resultList;
    }

    public static Pair<Boolean, LinkedList<Character>.Node> isPalindrome(LinkedList<Character>.Node node, int length) {
        if (length == 0) {
            return new Pair<Boolean, LinkedList<Character>.Node>(true, null);
        }
        if (length == 1) {
            return new Pair<Boolean, LinkedList<Character>.Node>(true, node.next());
        }
        if (length == 2) {
            LinkedList<Character>.Node nextNode = node.next().next();
            return new Pair<Boolean, LinkedList<Character>.Node>(node.getValue().equals(node.next().getValue()), nextNode);
        }
        Pair<Boolean, LinkedList<Character>.Node> subListPair = isPalindrome(node.next(), length -2);
        if (subListPair.getKey() == false) {
            return new Pair<Boolean, LinkedList<Character>.Node>(false, node);
        }
        LinkedList<Character>.Node mirrorNode = subListPair.getValue();
        return new Pair<Boolean, LinkedList<Character>.Node>(node.getValue().equals(mirrorNode.getValue()), mirrorNode.next());
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
