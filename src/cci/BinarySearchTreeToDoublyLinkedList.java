package cci;

import cci.domain.BiNode;

/**
 * Created by xzhang71 on 7/23/14.
 */
public class BinarySearchTreeToDoublyLinkedList {

    public static BiNode[] convert(BiNode root) {
        if (root == null) {
            return null;
        }

        BiNode[] result1 = convert(root.node1);
        BiNode[] result2 = convert(root.node2);

        BiNode leftHead = null;
        BiNode leftTail = null;

        if (result1 == null) {
            leftHead = root;
            leftTail = root;
        } else {
            leftHead = result1[0];
            leftTail = result1[1];
            leftTail.node2 = root;
            root.node1 = leftTail;
        }

        BiNode rightHead = null;
        BiNode rightTail = null;

        if (result2 == null) {
            rightHead = root;
            rightTail = root;
        } else {
            rightHead = result2[0];
            rightTail = result2[1];
            root.node2 = rightHead;
            rightHead.node1 = root;
        }

        return new BiNode[]{leftHead, rightTail};
    }

    public static void printLinkedList(BiNode[] headTail) {
        StringBuilder sb1 = new StringBuilder();
        BiNode head = headTail[0];
        while (head != null) {
            sb1.append(head.val + " ");
            head = head.node2;
        }
        System.out.println(sb1.toString());

        StringBuilder sb2 = new StringBuilder();
        BiNode tail = headTail[1];
        while (tail != null) {
            sb2.insert(0, tail.val + " ");
            tail = tail.node1;
        }
        System.out.println(sb2.toString());
    }

    public static void main(String[] args) {
        BiNode node0 = new BiNode(0);
        BiNode node1 = new BiNode(1);
        BiNode node2 = new BiNode(2);
        BiNode node3 = new BiNode(3);
        BiNode node4 = new BiNode(4);
        BiNode node5 = new BiNode(5);
        BiNode node6 = new BiNode(6);
        BiNode node7 = new BiNode(7);
        BiNode node8 = new BiNode(8);
        BiNode node9 = new BiNode(9);

        node5.node1 = node0;
        node0.node2 = node1;
        node1.node2 = node2;
        node2.node2 = node3;
        node3.node2 = node4;
        node5.node2 = node6;
        node6.node2 = node7;
        node7.node2 = node8;
        node8.node2 = node9;

        printLinkedList(convert(node5));
    }
}
