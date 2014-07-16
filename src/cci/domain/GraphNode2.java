package cci.domain;

import java.util.*;

/**
 * Created by xzhang71 on 7/15/14.
 */
public class GraphNode2 {
    public int val;
    public List<GraphNode2> neighbors = new ArrayList<>();

    public GraphNode2(int val) {
        this.val = val;
    }

    public static void recursiveDFS(GraphNode2 node) {
        Set<GraphNode2> visited = new HashSet<>();
        recursiveDFSGo(node, visited);
    }

    private static void recursiveDFSGo(GraphNode2 node, Set<GraphNode2> visited) {
        System.out.print(node.val + " ");
        visited.add(node);

        for (GraphNode2 n : node.neighbors) {
            if (!visited.contains(n)) {
                recursiveDFSGo(n, visited);
            }
        }
    }

    public static void interativeDFS(GraphNode2 node) {
        System.out.print("interativeDFS does not work well");
    }

    public static void recursiveBFS(GraphNode2 node) {
        System.out.print("recursiveBFS does not work well");
    }

    public static void breadthFirstSearchIterative(GraphNode2 node) {
        if (node == null) {
            return;
        }

        Queue<GraphNode2> cache = new LinkedList<>();
        Set<GraphNode2> visited = new HashSet<>();

        cache.add(node);
        System.out.print(node.val + " ");
        visited.add(node);

        while (!cache.isEmpty()) {
            GraphNode2 current = cache.poll();
            for (GraphNode2 n : current.neighbors) {
                if (!visited.contains(n)) {
                    cache.add(n);
                    System.out.print(n.val + " ");
                    visited.add(n);
                }
            }
        }
    }

    public static void main(String[] args) {
        GraphNode2 node0 = new GraphNode2(0);
        GraphNode2 node1 = new GraphNode2(1);
        GraphNode2 node2 = new GraphNode2(2);
        GraphNode2 node3 = new GraphNode2(3);
        GraphNode2 node4 = new GraphNode2(4);
        GraphNode2 node5 = new GraphNode2(5);

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

        GraphNode2.recursiveDFS(node0);
        System.out.println();

        GraphNode2.interativeDFS(node0);
        System.out.println();

        GraphNode2.recursiveBFS(node0);
        System.out.println();

        GraphNode2.breadthFirstSearchIterative(node0);
        System.out.println();
    }
}
