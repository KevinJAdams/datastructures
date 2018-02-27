package linkedlist;

import javafx.util.Pair;

import java.util.Random;
import java.util.Stack;


public class LinkedListTest {
    public static void main(String[] args) {
        String theString = "";
        if (args.length > 0) {
            theString = args[0];
        }
        LinkedList<Character> charList = LinkedList.initializeFromString(theString);
        int length = theString.length();
        Pair<Boolean, LinkedList<Character>.Node> resultPair = LinkedList.isPalindrome(charList.getHead(), length);
        System.out.println("isPalindrome: " + resultPair.getKey());
        System.out.println("isPalindromeReverseList: " + LinkedList.isPalindromeReverseList(charList));
    }



}
