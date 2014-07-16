package cci;

import cci.domain.BSTreeNode;

/**
 * Created by xzhang71 on 7/15/14.
 */
public class BSTreeRangeTraversal {

    public static void traverse(BSTreeNode root, int min, int max) {
        if (root == null) {
            return;
        }

        if (root.val < min) {
            traverse(root.right, min, max);
        } else if (root.val > max) {
            traverse(root.left, min, max);
        } else {
            traverse(root.left, min, max);
            System.out.print(root.val + " ");
            traverse(root.right, min, max);
        }
    }

    public static void main(String[] args) {
        BSTreeNode node0 = new BSTreeNode(0);
        BSTreeNode node1 = new BSTreeNode(1);
        BSTreeNode node2 = new BSTreeNode(2);
        BSTreeNode node3 = new BSTreeNode(3);
        BSTreeNode node4 = new BSTreeNode(4);
        BSTreeNode node5 = new BSTreeNode(5);
        BSTreeNode node6 = new BSTreeNode(6);
        BSTreeNode node7 = new BSTreeNode(7);
        BSTreeNode node8 = new BSTreeNode(8);
        BSTreeNode node9 = new BSTreeNode(9);

        node0.insert(node1);
        node0.insert(node2);
        node0.insert(node3);
        node0.insert(node4);
        node0.insert(node5);
        node0.insert(node6);
        node0.insert(node7);
        node0.insert(node8);
        node0.insert(node9);

        BSTreeRangeTraversal.traverse(node0, 5, 7);
    }
}