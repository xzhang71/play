package cci;

import cci.domain.TreeNode;

/**
 * Created by xzhang71 on 7/23/14.
 */
public class BinarySearchTreeToDoublyLinkedList {

    public static TreeNode[] convert(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode[] result1 = convert(root.left);
        TreeNode[] result2 = convert(root.right);

        TreeNode leftHead = null;
        TreeNode leftTail = null;

        if (result1 == null) {
            leftHead = root;
            leftTail = root;
        } else {
            leftHead = result1[0];
            leftTail = result1[1];
            leftTail.right = root;
            root.left = leftTail;
        }

        TreeNode rightHead = null;
        TreeNode rightTail = null;

        if (result2 == null) {
            rightHead = root;
            rightTail = root;
        } else {
            rightHead = result2[0];
            rightTail = result2[1];
            root.right = rightHead;
            rightHead.left = root;
        }

        return new TreeNode[]{leftHead, rightTail};
    }

    public static void printLinkedList(TreeNode[] headTail) {
        StringBuilder sb1 = new StringBuilder();
        TreeNode head = headTail[0];
        while (head != null) {
            sb1.append(head.val + " ");
            head = head.right;
        }
        System.out.println(sb1.toString());

        StringBuilder sb2 = new StringBuilder();
        TreeNode tail = headTail[1];
        while (tail != null) {
            sb2.insert(0, tail.val + " ");
            tail = tail.left;
        }
        System.out.println(sb2.toString());
    }

    public static void main(String[] args) {
        TreeNode node0 = new TreeNode(0);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(9);

        node5.left = node0;
        node0.right = node1;
        node1.right = node2;
        node2.right = node3;
        node3.right = node4;
        node5.right = node6;
        node6.right = node7;
        node7.right = node8;
        node8.right = node9;

        printLinkedList(convert(node5));
    }
}
