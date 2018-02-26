package linkedlist;

import javafx.util.Pair;

import java.util.Random;
import java.util.Stack;


public class LinkedListTest {
    public static void main(String[] args) {
        int listLength = 10;
        int maxValue = 10;
        if (args.length > 0) {
            listLength = Integer.parseInt(args[0]);
        }
        if (args.length > 1) {
            maxValue = Integer.parseInt(args[1]);
        }
        LinkedList<Integer> list1 = initializeRandomList(listLength, maxValue);
        System.out.println("list1: " + list1.toString());

        LinkedList<Integer> list2 = initializeRandomList(listLength, maxValue);
        System.out.println("list2: " + list2.toString());

        LinkedList<Integer> result = sum(list1, list2);
        System.out.println("sum: " + result.toString());

        LinkedList<Integer> resultReverseList = sumReverse(list1, list2);
        System.out.println("Reverse: " + resultReverseList);
    }

    private static LinkedList<Integer> initializeRandomList(int listLength,  int maxValue) {
        Random rand = new Random();
        int length = rand.nextInt(listLength) +1;
        LinkedList<Integer> result = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            result.append(rand.nextInt(maxValue));
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

}
