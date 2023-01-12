package binarytree;

/**
 * 完全二叉树的节点个数
 */
public class CountNodes {
    public static int countNodes(TreeNode node) {
        if (null == node) {
            return 0;
        }
        int leftNum = countNodes(node.left);
        int rightNum = countNodes(node.right);
        return leftNum + rightNum + 1;
    }
}
