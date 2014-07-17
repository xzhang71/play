package cci;

import cci.domain.TreeNode;

/**
 * Created by xzhang71 on 7/16/14.
 */
public class BSTCheck {

    /**
     * Binary search tree check. TS n h
     *
     * @param root
     * @return
     */
    public static boolean isBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (root.left != null && root.left.val > root.val) {
            return false;
        }

        if (root.right != null && root.right.val <= root.val) {
            return false;
        }

        return isBST(root.left) && isBST(root.right);
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

        // false
        System.out.println(isBST(node1));

        node1.val = 2;
        node4.val = 5;

        // true
        System.out.println(isBST(node1));
    }
}
