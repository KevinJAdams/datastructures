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
        LinkedList<Integer> list1 = LinkedList.initializeRandomList(listLength, maxValue);
        System.out.println("list1: " + list1.toString());

        LinkedList<Integer> list2 = LinkedList.initializeRandomList(listLength, maxValue);
        System.out.println("list2: " + list2.toString());

        LinkedList<Integer> result = LinkedList.sum(list1, list2);
        System.out.println("sum: " + result.toString());

        LinkedList<Integer> resultReverseList = LinkedList.sumReverse(list1, list2);
        System.out.println("Reverse: " + resultReverseList);
    }



}
