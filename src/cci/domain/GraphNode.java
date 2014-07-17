package cci.domain;

import java.util.*;

/**
 * Created by xzhang71 on 7/15/14.
 */
public class GraphNode {
    public int val;
    public List<GraphNode> neighbors = new ArrayList<>();

    public GraphNode(int val) {
        this.val = val;
    }

    public static void recursiveDFS(GraphNode node) {
        Set<GraphNode> visited = new HashSet<>();
        recursiveDFSGo(node, visited);
    }

    private static void recursiveDFSGo(GraphNode node, Set<GraphNode> visited) {
        System.out.print(node.val + " ");
        visited.add(node);

        for (GraphNode n : node.neighbors) {
            if (!visited.contains(n)) {
                recursiveDFSGo(n, visited);
            }
        }
    }

    public static void interativeDFS(GraphNode node) {
        System.out.print("interativeDFS does not work well");
    }

    public static void recursiveBFS(GraphNode node) {
        System.out.print("recursiveBFS does not work well");
    }

    public static void breadthFirstSearchIterative(GraphNode node) {
        if (node == null) {
            return;
        }

        Queue<GraphNode> cache = new LinkedList<>();
        Set<GraphNode> visited = new HashSet<>();

        cache.add(node);
        System.out.print(node.val + " ");
        visited.add(node);

        while (!cache.isEmpty()) {
            GraphNode current = cache.poll();
            for (GraphNode n : current.neighbors) {
                if (!visited.contains(n)) {
                    cache.add(n);
                    System.out.print(n.val + " ");
                    visited.add(n);
                }
            }
        }
    }

    public static void main(String[] args) {
        GraphNode node0 = new GraphNode(0);
        GraphNode node1 = new GraphNode(1);
        GraphNode node2 = new GraphNode(2);
        GraphNode node3 = new GraphNode(3);
        GraphNode node4 = new GraphNode(4);
        GraphNode node5 = new GraphNode(5);

        node0.neighbors.add(node1);
        node0.neighbors.add(node5);
        node0.neighbors.add(node3);

        node1.neighbors.add(node0);
        node1.neighbors.add(node2);

        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        node2.neighbors.add(node5);

        node3.neighbors.add(node2);
        node3.neighbors.add(node4);
        node3.neighbors.add(node0);

        node4.neighbors.add(node3);
        node4.neighbors.add(node5);

        node5.neighbors.add(node4);
        node5.neighbors.add(node0);
        node5.neighbors.add(node2);

        GraphNode.recursiveDFS(node0);
        System.out.println();

        GraphNode.interativeDFS(node0);
        System.out.println();

        GraphNode.recursiveBFS(node0);
        System.out.println();

        GraphNode.breadthFirstSearchIterative(node0);
        System.out.println();
    }
}
