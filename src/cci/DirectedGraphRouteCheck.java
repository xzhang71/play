package cci;

import cci.domain.GraphNode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by xzhang71 on 7/16/14.
 */
public class DirectedGraphRouteCheck {

    /**
     * Directed graph route check between two graph nodes.
     *
     * @param node1
     * @param node2
     * @return
     */
    public static boolean hasRouteBetween(GraphNode node1, GraphNode node2) {
        return hasRouteFromTo(node1, node2) || hasRouteFromTo(node2, node1);
    }

    private static boolean hasRouteFromTo(GraphNode from, GraphNode to) {
        if (from == to) {
            return true;
        }

        Queue<GraphNode> cache = new LinkedList<>();
        Set<GraphNode> visited = new HashSet<>();
        cache.add(from);
        visited.add(from);

        while (!cache.isEmpty()) {
            GraphNode current = cache.poll();
            for (GraphNode n : current.neighbors) {
                if (!visited.contains(n)) {
                    if (n == to) {
                        return true;
                    }
                    cache.add(n);
                    visited.add(n);
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        GraphNode node0 = new GraphNode(0);
        GraphNode node1 = new GraphNode(1);
        GraphNode node2 = new GraphNode(2);
        GraphNode node3 = new GraphNode(3);
        GraphNode node4 = new GraphNode(4);
        GraphNode node5 = new GraphNode(5);

        node0.neighbors.add(node1);
        node1.neighbors.add(node2);
        node2.neighbors.add(node3);
        node3.neighbors.add(node4);
        node4.neighbors.add(node0);

        // false
        System.out.println(DirectedGraphRouteCheck.hasRouteBetween(node0, node5));

        node5.neighbors.add(node1);

        // true
        System.out.println(DirectedGraphRouteCheck.hasRouteBetween(node0, node5));
    }
}
