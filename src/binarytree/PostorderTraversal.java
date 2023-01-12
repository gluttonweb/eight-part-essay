package binarytree;

import java.util.List;

/**
 * 后续遍历
 */
public class PostorderTraversal {
    public static void postorderTraversal(TreeNode node, List result) {
        if (null == node) {
            return;
        }
        postorderTraversal(node.left, result);
        postorderTraversal(node.right, result);
        result.add(node.value);
    }

    public static void main(String[] args) {

    }
}
