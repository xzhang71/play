package cci;

import cci.domain.TreeNode;

/**
 * Created by xzhang71 on 7/16/14.
 */
public class TreeBalanceCheck {

    public static int isBalanced(TreeNode root) {
        if (root == null) return 0;
        int left = isBalanced(root.left);
        if (left == -1) {
            return -1;
        }

        int right = isBalanced(root.right);
        if (right == -1) {
            return -1;
        }

        if (Math.abs(left - right) <= 1) {
            // IMPORTANT: don't forget 1
            return 1 + Math.max(left, right);
        } else {
            return -1;
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
        TreeNode node8 = new TreeNode(8);

        node1.left = node2;
        node1.right = node3;
        node2.right = node4;
        node4.left = node5;
        node4.right = node6;
        node3.right = node7;

        // -1 < 0: not balanced
        System.out.println(isBalanced(node1));

        node2.left = node8;

        // 4 >= 0: balanced
        System.out.println(isBalanced(node1));
    }
}
