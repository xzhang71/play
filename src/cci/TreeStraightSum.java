package cci;

import cci.domain.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xzhang71 on 7/16/14.
 */
public class TreeStraightSum {

    public static void straightSum(TreeNode root, int sum) {
        straightSum(root, sum, new ArrayList<Integer>());
    }

    private static void straightSum(TreeNode root, int sum, List<Integer> cache) {
        if (root == null) {
            return;
        }

        cache.add(root.val);

        straightSum(root.left, sum, cache);
        straightSum(root.right, sum, cache);

        for (int i = cache.size() - 1; i >= 0; i--) {
            sum -= cache.get(i);
            if (sum == 0) {
                printPath(cache, i, cache.size() - 1);
            }
        }

        cache.remove(cache.size() - 1);
    }

    private static void printPath(List<Integer> cache, int i, int j) {
        for (int k = i; k <= j; k++) {
            System.out.print(cache.get(k) + " ");
        }
        System.out.println();
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

        for (int i = 0; i <= 10; i++) {
            System.out.printf("sum %d\n", i);
            TreeStraightSum.straightSum(node1, i);
            System.out.printf("\n");
        }

    }
}
