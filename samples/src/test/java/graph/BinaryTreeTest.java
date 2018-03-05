package graph;

import java.util.Arrays;

public class BinaryTreeTest {
    static int[] values = new int[] { 1, 2, 3, 4, 5, 6, 7, 8};

    public static void main(String[] args) {
        System.out.println("Values: " + Arrays.toString(values));
        BinaryTree tree = BinaryTree.createMinHeightTree(values);
        System.out.println("Tree: " + tree);
    }
}
