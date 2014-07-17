package cci;

import cci.domain.TreeNode;

/**
 * Created by xzhang71 on 7/16/14.
 */
public class TreeCommonAncestor {

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode node1, TreeNode node2) {
        if (search(node1, node2)) return node1;
        if (search(node2, node1)) return node2;
        return lowestCommonAncestorGo(root, node1, node2);
    }

    private static boolean search(TreeNode root, TreeNode target) {
        if (root == null) {
            return false;
        }

        if (root == target) {
            return true;
        }

        return search(root.left, target) || search(root.right, target);
    }

    private static TreeNode lowestCommonAncestorGo(TreeNode root, TreeNode node1, TreeNode node2) {
        if (root == null) {
            return null;
        }

        if (root == node1 || root == node2) {
            return root;
        }

        TreeNode left = lowestCommonAncestorGo(root.left, node1, node2);
        if (left != null && left != node1 && left != node2) {
            return left;
        }

        TreeNode right = lowestCommonAncestorGo(root.right, node1, node2);

        if (left != null && right != null) {
            return root;
        } else if (left != null) {
            return left;
        } else if (right != null) {
            return right;
        } else {
            return null;
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

        // 4
        System.out.println(TreeCommonAncestor.lowestCommonAncestor(node1, node5, node6).val);
        // 2
        System.out.println(TreeCommonAncestor.lowestCommonAncestor(node1, node2, node6).val);
        // 1
        System.out.println(TreeCommonAncestor.lowestCommonAncestor(node1, node2, node7).val);
        // 1
        System.out.println(TreeCommonAncestor.lowestCommonAncestor(node1, node1, node3).val);
        // 7
        System.out.println(TreeCommonAncestor.lowestCommonAncestor(node1, node7, node7).val);
        // 1
        System.out.println(TreeCommonAncestor.lowestCommonAncestor(node1, node6, node7).val);
        // 1
        System.out.println(TreeCommonAncestor.lowestCommonAncestor(node1, node3, node4).val);
    }
}
