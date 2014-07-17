package cci.domain;

import java.util.Stack;

/**
 * Created by xzhang71 on 7/15/14.
 */
public class TreeNode {
    public int val;
    public TreeNode parent = null;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    public static void preorderRecursiveTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        System.out.print(root.val + " ");
        preorderRecursiveTraversal(root.left);
        preorderRecursiveTraversal(root.right);
    }

    public static void preorderIterativeTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> cache = new Stack<>();
        cache.push(root);
        while (!cache.isEmpty()) {
            TreeNode current = cache.pop();
            System.out.print(current.val + " ");
            if (current.right != null) {
                cache.push(current.right);
            }
            if (current.left != null) {
                cache.push(current.left);
            }
        }
    }

    public static void inorderRecursiveTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        inorderRecursiveTraversal(root.left);
        System.out.print(root.val + " ");
        inorderRecursiveTraversal(root.right);
    }

    public static void inorderIterativeTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> cache = new Stack<>();
        TreeNode current = root;

        while (!cache.isEmpty() || current != null) {
            if (current == null) {
                current = cache.pop();
                System.out.print(current.val + " ");
                current = current.right;
            } else {
                cache.push(current);
                current = current.left;
            }
        }
    }

    /*
    public static void inorderIterativeTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> cache = new Stack<>();
        cache.push(root);
        TreeNode previous = null;

        while (!cache.isEmpty()) {
            TreeNode current = cache.peek();
            if (previous == null || previous.left == current || previous.right == current) {
                if (current.left != null) {
                    cache.push(current.left);
                } else {
                    System.out.print(current.val + " ");
                    if (current.right != null) {
                        cache.push(current.right);
                    } else {
                        cache.pop();
                    }
                }
            } else if (previous == current.left) {
                System.out.print(current.val + " ");
                if (current.right != null) {
                    cache.push(current.right);
                } else {
                    cache.pop();
                }
            } else if (previous == current.right) {
                cache.pop();
            }

            previous = current;
        }
    }
    */

    public static void postorderRcursiveTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        postorderRcursiveTraversal(root.left);
        postorderRcursiveTraversal(root.right);
        System.out.print(root.val + " ");
    }

    public static void postorderIterativeTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> cache = new Stack<>();
        cache.push(root);
        TreeNode previous = null;

        while (!cache.isEmpty()) {
            TreeNode current = cache.peek();
            if (previous == null || current == previous.left || current == previous.right) {
                if (current.left != null) {
                    cache.push(current.left);
                } else if (current.right != null) {
                    cache.push(current.right);
                } else {
                    System.out.print(current.val + " ");
                    cache.pop();
                }
            } else if (previous == current.left) {
                if (current.right != null) {
                    cache.push(current.right);
                } else {
                    System.out.print(current.val + " ");
                    cache.pop();
                }
            } else if (previous == current.right) {
                System.out.print(current.val + " ");
                cache.pop();
            }
            previous = current;
        }
    }

    /*
    public static void postorderIterativeTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<Integer> vals = new Stack<>();
        Stack<TreeNode> cache = new Stack<>();
        cache.push(root);

        while (!cache.isEmpty()) {
            TreeNode current = cache.pop();
            vals.push(current.val);
            if (current.left != null) {
                cache.push(current.left);
            }
            if (current.right != null) {
                cache.push(current.right);
            }
        }

        while (!vals.isEmpty()) {
            System.out.print(vals.pop() + " ");
        }
    }
    */

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

        TreeNode.preorderRecursiveTraversal(node1);
        System.out.println();
        TreeNode.preorderIterativeTraversal(node1);
        System.out.println();
        System.out.println();

        TreeNode.inorderRecursiveTraversal(node1);
        System.out.println();
        TreeNode.inorderIterativeTraversal(node1);
        System.out.println();
        System.out.println();

        TreeNode.postorderRcursiveTraversal(node1);
        System.out.println();
        TreeNode.postorderIterativeTraversal(node1);
        System.out.println();
    }
}
