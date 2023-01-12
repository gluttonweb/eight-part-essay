package binarytree;

/**
 * 平衡二叉树
 */
public class IsBalanced {
    public static boolean isBalanced(TreeNode node) {
        if (null == node) {
            return false;
        }
        try {
            int leftHeight = getHeight(node.left);
            int rightHeight = getHeight(node.right);
            if (Math.abs(leftHeight - rightHeight) > 1) {
                throw new Exception("非平衡二叉树");
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static int getHeight(TreeNode node) throws Exception {
        if (null == node) {
            return 0;
        }
        int leftHeight = 0;
        int rightHeight = 0;
        if (null != node.left) {
            leftHeight = getHeight(node.left);
        }
        if (null != node.right) {
            rightHeight = getHeight(node.right);
        }
        if (Math.abs(leftHeight - rightHeight) > 1) {
            throw new Exception("非平衡二叉树");
        }
        return Math.max(leftHeight, rightHeight);
    }
}
