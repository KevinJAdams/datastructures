package graph;

import queue.Queue;

public class Graph {
    public GraphNode[] nodes;

    public void resetVisited() {
        for (GraphNode node : nodes) {
            node.visited = false;
        }
    }
    public static boolean routeExists(GraphNode node1, GraphNode node2) {
        node1.visited = true;
        for (GraphNode node : node1.children) {
            if (node == node2) {
                return true;
            }
            if (!node.visited) {
                boolean result = routeExists(node, node2);
                if (result) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean routeExistsBreadthFirst(GraphNode node1, GraphNode node2) {
        Queue<GraphNode> nodeQueue = new Queue<>();
        node1.visited = true;
        nodeQueue.add(node1);
        while (!nodeQueue.isEmpty()) {
            GraphNode node = nodeQueue.remove();
            if (node == node2) {
                return true;
            }
            for (GraphNode child : node.children) {
                if (!child.visited) {
                    child.visited = true;
                    nodeQueue.add(child);
                }
            }
        }
        return false;
    }
}
