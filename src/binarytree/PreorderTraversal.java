package binarytree;

import java.util.List;

/**
 * εεΊιε
 */
public class PreorderTraversal {

    public void preorderTraversal(TreeNode node, List result) {
        if (null == node) {
            return;
        }
        result.add(node.value);
        preorderTraversal(node.left, result);
        preorderTraversal(node.left, result);
    }

    public static void main(String[] args) {

    }
}
