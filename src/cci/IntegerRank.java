package cci;

import cci.domain.TreeNode;

/**
 * Created by xzhang71 on 7/21/14.
 */
public class IntegerRank {

    private static TreeNode root;

    public static void track(int val) {
        if (root == null) {
            root = new TreeNode(val, 0);
        } else {
            TreeNode current = root;
            int rank = 0;
            while (true) {
                if (val <= current.val) {
                    current.rank++;
                    if (current.left != null) {
                        current = current.left;
                    } else {
                        current.left = new TreeNode(val, rank);
                        break;
                    }
                } else {
                    if (current.right != null) {
                        current = current.right;
                    } else {
                        current.right = new TreeNode(val, current.rank + 1);
                        break;
                    }
                }
            }
        }
    }

    public static int getRankOfNumber(int val) {
        TreeNode current = root;
        while (current != null) {
            if (val < current.val) {
                current = current.left;
            } else if (val > current.val) {
                current = current.right;
            } else {
                return current.rank;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] input = {5, 1, 4, 4, 5, 9, 7, 13, 3};

        for (int i : input) {
            IntegerRank.track(i);
        }

        for (int i : input) {
            System.out.printf("%d's rank is %d\n", i, IntegerRank.getRankOfNumber(i));
        }
    }
}
