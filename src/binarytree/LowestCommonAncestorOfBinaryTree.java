package binarytree;

/**
 * 二叉树的最近公共祖先
 * ⚠️查最近公共祖先，最好是自底向上查找（即回溯），而后序遍历就是天然的回溯过程
 */
public class LowestCommonAncestorOfBinaryTree {

    public static TreeNode lowestCommoAncestorOfBinaryTree(TreeNode node, Integer a, Integer b) {
        if (null == node) {
            return null;
        }

        // 后序遍历
        TreeNode leftRs = null;
        TreeNode rightRs = null;
        if (null != node.left) {
            leftRs = lowestCommoAncestorOfBinaryTree(node.left, a, b);
        }
        if (null != node.right) {
            rightRs = lowestCommoAncestorOfBinaryTree(node.right, a, b);
        }
        if (node.value.equals(a) || node.value.equals(b)) {
            return node;
        }
        // ⚠️注意这儿的返回条件
        if (null == leftRs && null == rightRs) {
            return null;
        } else if (null == leftRs && null != rightRs) {
            return rightRs;
        } else if (null != leftRs && null == rightRs) {
            return leftRs;
        } else if (null != leftRs && null != rightRs) {
            return node;
        }
        return null;
    }

    public static void main(String[] args) {

    }
}
