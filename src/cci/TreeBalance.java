package cci;

import cci.domain.TreeNode;

/**
 * Created by xzhang71 on 7/16/14.
 */
public class TreeBalance {

    /**
     * Create a binary tree from array with minimum height
     *
     * @param arr
     * @return
     */
    public static TreeNode arrayToBalancedTree(int[] arr) {
        return arrayToBalancedTreeGo(arr, 0, arr.length - 1);
    }

    public static TreeNode arrayToBalancedTreeGo(int[] arr, int left, int right) {
        if (left > right) {
            return null;
        }

        if (left == right) {
            return new TreeNode(arr[left]);
        }

        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(arr[mid]);
        root.left = arrayToBalancedTreeGo(arr, left, mid - 1);
        root.right = arrayToBalancedTreeGo(arr, mid + 1, right);

        return root;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        TreeNode root = TreeBalance.arrayToBalancedTree(arr);

        // 4
        System.out.println(TreeBalanceCheck.isBalanced(root));
    }
}
