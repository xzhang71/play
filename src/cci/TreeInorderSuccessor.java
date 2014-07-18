package cci;

import cci.domain.TreeNode;

/**
 * Created by xzhang71 on 7/16/14.
 */
public class TreeInorderSuccessor {

    /**
     * Inorder successor of a tree node, assuming each tree node has a link to its parent
     *
     * @param node
     * @return
     */
    public static TreeNode inorderSuccessor(TreeNode node) {
        if (node.right != null) {
            TreeNode current = node.right;
            while (current.left != null) {
                current = current.left;
            }
            return current;
        }

        if (node.parent != null && node.parent.left == node) {
            return node.parent;
        }

        // IMPORTANT
        if (node.parent != null && node.parent.right == node) {
            TreeNode current = node.parent;
            while (current.parent != null && current == current.parent.right) {
                current = current.parent;
            }
            return current.parent;
        }

        return null;
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

        // 3 5 7 6 4 1 null
        System.out.println(TreeInorderSuccessor.inorderSuccessor(node1).val);
        System.out.println(TreeInorderSuccessor.inorderSuccessor(node2).val);
        System.out.println(TreeInorderSuccessor.inorderSuccessor(node3).val);
        System.out.println(TreeInorderSuccessor.inorderSuccessor(node4).val);
        System.out.println(TreeInorderSuccessor.inorderSuccessor(node5).val);
        System.out.println(TreeInorderSuccessor.inorderSuccessor(node6).val);
        System.out.println(TreeInorderSuccessor.inorderSuccessor(node7));
    }
}
