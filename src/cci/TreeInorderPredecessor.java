package cci;

import cci.domain.TreeNode;

/**
 * Created by xzhang71 on 7/20/14.
 */
public class TreeInorderPredecessor {

    public static TreeNode inorderPredecessor(TreeNode node) {
        if (node.left != null) {
            return node.left;
        }

        TreeNode current = node;
        while (current.parent != null && current.parent.left == node) {
            current = current.parent;
        }
        return current.parent;
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
        node2.parent = node1;
        node1.right = node3;
        node3.parent = node1;
        node2.right = node4;
        node4.parent = node2;
        node4.left = node5;
        node5.parent = node4;
        node4.right = node6;
        node6.parent = node4;
        node3.right = node7;
        node7.parent = node3;

        // 2 null 1 5 2 4 3
        System.out.println(TreeInorderPredecessor.inorderPredecessor(node1).val);
        System.out.println(TreeInorderPredecessor.inorderPredecessor(node2));
        System.out.println(TreeInorderPredecessor.inorderPredecessor(node3).val);
        System.out.println(TreeInorderPredecessor.inorderPredecessor(node4).val);
        System.out.println(TreeInorderPredecessor.inorderPredecessor(node5).val);
        System.out.println(TreeInorderPredecessor.inorderPredecessor(node6).val);
        System.out.println(TreeInorderPredecessor.inorderPredecessor(node7).val);
    }
}
