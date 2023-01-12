package binarytree;

/**
 * 左叶子之和
 * 核心在于判断是否为左叶子：节点A的左孩子不为空，且左孩子的左右孩子都为空（说明是叶子节点），那么A节点的左孩子为左叶子节点
 */
public class SumOfLeftLeaves {

    public static boolean isLeftLeaves(TreeNode node) {
        if (null == node) {
            return false;
        }
        if (null != node.left && null == node.left.left && null == node.left.right) {
            return true;
        }
        return false;
    }

    public static int sumOfLeftLeaves(TreeNode node) {
        if (null == node) {
            return 0;
        }
        int sum = 0;
        if (isLeftLeaves(node)) {
            sum += (int) node.left.value;
        }
        if (null != node.left) {
            sum += sumOfLeftLeaves(node.left);
        }
        if (null != node.right) {
            sum += sumOfLeftLeaves(node.right);
        }
        return sum;
    }
}
