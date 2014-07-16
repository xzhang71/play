package cci;

import cci.domain.BSTreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by xzhang71 on 7/15/14.
 */
public class BSTreeBalance {

    public static BSTreeNode balance(BSTreeNode root) {
        List<BSTreeNode> cache = new ArrayList<>();
        inorderTraverse(root, cache);
        for (BSTreeNode node : cache) {
            node.left = null;
            node.right = null;
        }

        return balanceGo(cache, 0, cache.size() - 1);
    }

    private static BSTreeNode balanceGo(List<BSTreeNode> cache, int left, int right) {
        if (left > right) {
            return null;
        }

        if (left == right) {
            return cache.get(left);
        }

        int mid = (left + right) / 2;

        BSTreeNode current = cache.get(mid);
        current.left = balanceGo(cache, left, mid - 1);
        current.right = balanceGo(cache, mid + 1, right);
        return current;
    }

    private static void inorderTraverse(BSTreeNode root, List<BSTreeNode> cache) {
        if (root == null) {
            return;
        }

        Stack<BSTreeNode> stack = new Stack<>();
        BSTreeNode current = root;

        while (!stack.isEmpty() || current != null) {
            if (current == null) {
                current = stack.pop();
                cache.add(current);
                current = current.right;
            } else {
                stack.push(current);
                current = current.left;
            }
        }
    }


    public static void main(String[] args) {
        BSTreeNode node0 = new BSTreeNode(0);
        BSTreeNode node1 = new BSTreeNode(1);
        BSTreeNode node2 = new BSTreeNode(2);
        BSTreeNode node3 = new BSTreeNode(3);
        BSTreeNode node4 = new BSTreeNode(4);
        BSTreeNode node5 = new BSTreeNode(5);
        BSTreeNode node6 = new BSTreeNode(6);
        BSTreeNode node7 = new BSTreeNode(7);
        BSTreeNode node8 = new BSTreeNode(8);
        BSTreeNode node9 = new BSTreeNode(9);

        node0.insert(node1);
        node0.insert(node2);
        node0.insert(node3);
        node0.insert(node4);
        node0.insert(node5);
        node0.insert(node6);
        node0.insert(node7);
        node0.insert(node8);
        node0.insert(node9);

        BSTreeNode root = BSTreeBalance.balance(node0);
    }
}
