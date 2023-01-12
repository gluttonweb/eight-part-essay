package binarytree;

import java.util.List;

/**
 * 中序遍历
 */
public class InorderTraversal {
    public static void inorderTraversal(TreeNode node, List result) {
        if (null == node) {
            return;
        }
        inorderTraversal(node.left, result);
        result.add(node.value);
        inorderTraversal(node.right, result);
    }

    public static void main(String[] args) {

    }
}
