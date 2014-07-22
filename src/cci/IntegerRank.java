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
            while (true) {
                if (val <= current.val) {
                    current.leftBranchSize++;
                    if (current.left == null) {
                        current.left = new TreeNode(val, 0);
                        break;
                    } else {
                        current = current.left;
                    }
                } else {
                    if (current.right == null) {
                        current.right = new TreeNode(val, 0);
                        break;
                    } else {
                        current = current.right;
                    }
                }
            }
        }
    }

    public static int getRankOfNumber(int val) {
        TreeNode current = root;
        int rank = 0;
        while (current != null) {
            if (val == current.val) {
                return rank + current.leftBranchSize;
            } else if (val < current.val) {
                current = current.left;
            } else {
                rank += current.leftBranchSize + 1;
                current = current.right;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] input = {5, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        for (int i : input) {
            IntegerRank.track(i);
        }

        for (int i : input) {
            System.out.printf("%d's rank is %d\n", i, IntegerRank.getRankOfNumber(i));
        }
    }
}