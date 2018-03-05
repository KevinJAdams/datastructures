package graph;

public class BTreeNode {
    public int value;
    public BTreeNode left;
    public BTreeNode right;
    public int depth;

    public BTreeNode(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(value + " ");
        if (left != null) {
            result.append("Left: " + left.toString());
        }
        if (right != null) {
            result.append("Right: " + right.toString());
        }
        return result.toString();
    }

}
