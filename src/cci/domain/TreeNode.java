package cci.domain;

import java.util.Stack;

/**
 * Created by xzhang on 6/19/14.
 */
public class TreeNode {
    public int value;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int value) {
        this.value = value;
    }

    public static void preorderTraversalRecursive(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.value);
        preorderTraversalRecursive(root.left);
        preorderTraversalRecursive(root.right);
    }

    public static void preorderTraversalIterative(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            System.out.print(current.value);

            if (current.right != null) {
                stack.push(current.right);
            }

            if (current.left != null) {
                stack.push(current.left);
            }
        }
    }

    public static void inorderTraversalRecursive(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraversalRecursive(root.left);
        System.out.print(root.value);
        inorderTraversalRecursive(root.right);
    }

    public static void inorderTraversalIterative(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while (!stack.isEmpty() || current != null) {
            if (current == null) {
                current = stack.pop();
                System.out.print(current.value);
                current = current.right;
            } else {
                stack.push(current);
                current = current.left;
            }
        }
    }

    public static void postorderTraversalRecursive(TreeNode root) {
        if (root == null) {
            return;
        }
        postorderTraversalRecursive(root.left);
        postorderTraversalRecursive(root.right);
        System.out.print(root.value);
    }

    public static void postorderTraversalIterative(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode prev = null;

        while (!stack.isEmpty()) {
            TreeNode current = stack.peek();

            if (prev == null || prev.left == current || prev.right == current) {
                if (current.left != null) {
                    stack.push(current.left);
                } else if (current.right != null) {
                    stack.push(current.right);
                } else {
                    System.out.print(current.value);
                    stack.pop();
                }
            } else if (current.left == prev) {
                if (current.right != null) {
                    stack.push(current.right);
                } else {
                    System.out.print(current.value);
                    stack.pop();
                }
            } else if (current.right == prev) {
                System.out.print(current.value);
                stack.pop();
            } else {
                // something is wrong
            }
            prev = current;
        }
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);

        node1.left = node2;
        node1.right = node3;
        node2.right = node4;
        node4.left = node5;
        node4.right = node6;
        node3.right = node7;

        TreeNode.preorderTraversalRecursive(node1);
        System.out.println();
        TreeNode.preorderTraversalIterative(node1);
        System.out.println();
        TreeNode.inorderTraversalRecursive(node1);
        System.out.println();
        TreeNode.inorderTraversalIterative(node1);
        System.out.println();
        TreeNode.postorderTraversalRecursive(node1);
        System.out.println();
        TreeNode.postorderTraversalIterative(node1);
    }
}
