package binarytree;

/**
 * 验证二叉搜索树
 */
public class ValidateBST {

    public static boolean validateBST(TreeNode node) {
        if (node.left.value > node.value) {
            return false;
        }
        if (node.right.value < node.value) {
            return false;
        }
        return validateBST(node.left) && validateBST(node.right);
    }

    public static void main(String[] args) {

    }
}
