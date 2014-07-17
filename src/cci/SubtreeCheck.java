package cci;

import cci.domain.TreeNode;

/**
 * Created by xzhang71 on 7/16/14.
 */
public class SubtreeCheck {

    public static boolean isSubtree(TreeNode large, TreeNode small) {
        if (small == null) {
            return true;
        }

        return isSubtreeGo(large, small);
    }

    private static boolean isSubtreeGo(TreeNode large, TreeNode small) {
        if (large == null) {
            return false;
        }

        if (large.val == small.val && isTreeIdentical(large, small)) {
            return true;
        }

        return isSubtreeGo(large.left, small) || isSubtreeGo(large.right, small);
    }

    private static boolean isTreeIdentical(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }

        if (root1 == null || root2 == null) {
            return false;
        }

        return root1.val == root2.val && isTreeIdentical(root1.left, root2.left) && isTreeIdentical(root1.right, root2.right);
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

        System.out.println(SubtreeCheck.isSubtree(node1, node1));
        System.out.println(SubtreeCheck.isSubtree(node1, node2));
        System.out.println(SubtreeCheck.isSubtree(node1, node3));
        System.out.println(SubtreeCheck.isSubtree(node1, node4));
        System.out.println(SubtreeCheck.isSubtree(node1, node5));
        System.out.println(SubtreeCheck.isSubtree(node1, node6));
        System.out.println(SubtreeCheck.isSubtree(node1, node7));

        System.out.println();

        System.out.println(SubtreeCheck.isSubtree(node1, new TreeNode(1))); // false
        System.out.println(SubtreeCheck.isSubtree(node1, new TreeNode(2))); // false
        System.out.println(SubtreeCheck.isSubtree(node1, new TreeNode(3))); // false
        System.out.println(SubtreeCheck.isSubtree(node1, new TreeNode(4))); // false
        System.out.println(SubtreeCheck.isSubtree(node1, new TreeNode(5))); // true
        System.out.println(SubtreeCheck.isSubtree(node1, new TreeNode(6))); // true
        System.out.println(SubtreeCheck.isSubtree(node1, new TreeNode(7))); // true
    }
}
