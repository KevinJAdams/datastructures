package graph;

import queue.Queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTree {
    public BTreeNode root;

    public static BinaryTree createMinHeightTree(int[] values) {
        BinaryTree tree = new BinaryTree();
        int midIndex = values.length/2;
        tree.root = new BTreeNode(values[midIndex]);
        tree.root.left = addValues(values, 0, midIndex-1);
        tree.root.right = addValues(values, midIndex + 1, values.length-1);
        return tree;
    }

    public static BTreeNode addValues(int[] values, int startIndex, int endIndex) {
        if (startIndex > endIndex) {
            return null;
        }
        int midIndex = startIndex + (endIndex - startIndex)/2;
        BTreeNode result = new BTreeNode(values[midIndex]);
        result.left = addValues(values, startIndex, midIndex-1);
        result.right = addValues(values, midIndex+1, endIndex);
        return result;
    }

    public static List<LinkedList>  getListsByDepth(BinaryTree tree) {
        List<LinkedList> resultList = new ArrayList<LinkedList>();
        Queue<BTreeNode> nodeQueue = new Queue<>();
        tree.root.depth = 0;
        nodeQueue.add(tree.root);

        while (!nodeQueue.isEmpty()) {
            BTreeNode node = nodeQueue.remove();
            node.left.depth = node.depth+1;
            node.right.depth = node.depth+1;
            nodeQueue.add(node.left);
            nodeQueue.add(node.right);
            if (resultList.size() <= node.depth) {
                resultList.add(new LinkedList());
            }
            resultList.get(node.depth).add(node);
        }
        return resultList;
    }



    public String toString() {
        return root.toString();
    }
}
