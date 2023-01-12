package binarytree;

/**
 * 二叉搜索数的最近公共祖先
 * ⚠️分析：因为是有序树，所有如果中间节点是q和p的公共祖先，那么中间节点的数组一定是在 [p, q]区间的。
 * 那么只要从上到下去遍历，遇到 cur节点是数值在[p, q]区间中则一定可以说明该节点cur就是q 和 p的公共祖先。
 * 那问题来了，一定是最近公共祖先吗？答案是：是！所以当我们从上向下去递归遍历，第一次遇到cur节点是数值在[p, q]区间中，那么cur就是 p和q的最近公共祖先！
 */
public class LowestCommonAncestorOfBST {

    public static TreeNode lowestCommonAncestorOfBST(TreeNode node, Integer a, Integer b) {
        if (null == node) {
            return null;
        }
        if (node.value < a) {
            return lowestCommonAncestorOfBST(node.left, a, b);
        } else if (node.value > b) {
            return lowestCommonAncestorOfBST(node.right, a, b);
        }
        return node;
    }

    public static void main(String[] args) {
        Integer a = 5;
        Integer b = 10;
        TreeNode root = new TreeNode();
        if (a < b) {
            lowestCommonAncestorOfBST(root, a, b);
        } else {
            lowestCommonAncestorOfBST(root, b, a);
        }

    }
}
