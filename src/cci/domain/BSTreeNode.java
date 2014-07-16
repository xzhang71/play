package cci.domain;

/**
 * Created by xzhang71 on 7/15/14.
 */
public class BSTreeNode {
    public int val;
    public BSTreeNode left;
    public BSTreeNode right;

    public BSTreeNode(int val) {
        this.val = val;
    }

    public void insert(BSTreeNode item) {
        if (item.val <= val) {
            if (this.left == null) {
                this.left = item;
            } else {
                this.left.insert(item);
            }
        } else {
            if (this.right == null) {
                this.right = item;
            } else {
                this.right.insert(item);
            }
        }
    }
}
