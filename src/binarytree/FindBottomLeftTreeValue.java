package binarytree;

/**
 * 找树左下角的值
 * ⚠️ 如何保证遍历后最深的节点是左叶子而不是右叶子，只需保证最深路径先遍历到的是左叶子而不是右叶子即可
 * （前序遍历、中序遍历、后序遍历、层序遍历都是先遍历左边再遍历右边，所以都可以）
 */
public class FindBottomLeftTreeValue {

    public static Integer MAX_DEEP = -1;
    public static Integer LEFT_VALUE = null;

    public static void findBottomLeftTreeValue(TreeNode node, Integer deep) {
        if (null == node) {
            return;
        }
        if (null == node.left && null == node.right) {
            if (deep > MAX_DEEP) {
                LEFT_VALUE = (Integer) node.value;
                MAX_DEEP = deep;
            }
        }
        if (null != node.left) {
            findBottomLeftTreeValue(node.left, deep + 1);
        }
        if (null != node.right) {
            findBottomLeftTreeValue(node.right, deep + 1);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        findBottomLeftTreeValue(root, 0);
    }
}
