package cci;

import cci.domain.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by xzhang71 on 7/16/14.
 */
public class TreeLevelsToLinkedLists {

    /**
     * Create linked lists for each level of a tree
     *
     * @param root
     * @return
     */
    public static List<LinkedList<TreeNode>> treeLeveToLinkedLists(TreeNode root) {
        List<LinkedList<TreeNode>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        LinkedList<TreeNode> cache = new LinkedList<>();
        cache.add(root);

        while (!cache.isEmpty()) {
            result.add(cache);
            LinkedList<TreeNode> tempCache = new LinkedList<>();
            for (TreeNode n : cache) {
                if (n.left != null) {
                    tempCache.add(n.left);
                }
                if (n.right != null) {
                    tempCache.add(n.right);
                }
            }
            cache = tempCache;
        }

        return result;
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

        List<LinkedList<TreeNode>> result = TreeLevelsToLinkedLists.treeLeveToLinkedLists(node1);
        for (LinkedList<TreeNode> level : result) {
            for (TreeNode node : level) {
                System.out.print(node.val + " ");
            }
            System.out.println();
        }
    }
}
