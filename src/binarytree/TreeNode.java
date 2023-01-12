package binarytree;

/**
 * 二叉树数据结构
 */
public class TreeNode {

    public Integer value;

    public TreeNode left;

    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(Integer value) {
        this.value = value;
    }

    public TreeNode(Integer value, TreeNode left, TreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}
