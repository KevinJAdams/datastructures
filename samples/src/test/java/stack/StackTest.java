package stack;

public class StackTest {
    public static void main(String[] args) {
        int depth = 10;
        int maxValue = 9;
        if (args.length > 0) {
            depth = Integer.parseInt(args[0]);
        }
        if (args.length > 1) {
            maxValue = Integer.parseInt(args[1]);
        }
        Stack<Integer> stack = Stack.createRandomStack(depth, maxValue);
        System.out.println("Initial Stack: " + stack.toString());
        Stack.sort(stack);
        System.out.println("Sorted Stack: " + stack.toString());
    }
}
