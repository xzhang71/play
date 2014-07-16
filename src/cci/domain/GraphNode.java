//package cci.domain;
//
//import java.util.*;
//
///**
// * Created by xzhang on 6/19/14.
// */
//public class GraphNode {
//    private List<GraphNode> adjacent = new ArrayList<>();
//
//    public static void depthFirstTraversalRecursive(GraphNode root) {
//        if (root == null) {
//            return;
//        }
//
//        Set<GraphNode> visited = new HashSet<>();
//
//        depthFirstTraversalRecursiveGo(root, visited);
//    }
//
//    private static void depthFirstTraversalRecursiveGo(GraphNode root, Set<GraphNode> visited) {
//        for (GraphNode node : root.adjacent) {
//            if (!visited.contains(node)) {
//                depthFirstTraversalRecursive(node);
//            }
//        }
//    }
//
//    public static void depthFirstTraversalIterative(GraphNode root) {
//        if (root == null) {
//            return;
//        }
//
//        Set<GraphNode> visited = new HashSet<>();
//        Stack<GraphNode> stack = new Stack<>();
//        visited.add(root);
//        stack.push(root);
//
//        while (!stack.isEmpty()) {
//            GraphNode current = stack.pop();
//            if (!visited.contains(current)) {
//                stack.push(current);
//                for (GraphNode node : current.adjacent) {
//                    visited.add(node);
//                }
//            }
//        }
//    }
//
//    public static void breadthFirstTraversalIterative(GraphNode root) {
//        if (root == null) {
//            return;
//        }
//
//        Set<GraphNode> visited = new HashSet<>();
//        Queue<GraphNode> queue = new LinkedList<>();
//        visited.add(root);
//        queue.add(root);
//
//        while (!queue.isEmpty()) {
//            GraphNode current = queue.poll();
//            for (GraphNode node : current.adjacent) {
//                if (!visited.contains(node)) {
//                    visited.add(node);
//                    queue.add(node);
//                }
//            }
//        }
//    }
//}