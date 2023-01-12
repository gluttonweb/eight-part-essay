package binarytree;

/**
 * 修剪二叉搜索树
 * 节点值 < l，若节点无左右子节点，直接删除；若有右节点，删除节点后将右节点提上来替换该节点；若有左节点，和该节点一起删除
 * 节点值 > r，若节点无左右子节点，直接删除；若有左节点，删除节点后将左节点提上来替换该节点；若有右节点，和该节点一起删除
 */
public class TrimBST {

    public static TreeNode trimBST(TreeNode node, Integer l, Integer r) {
        if (null == node) {
            return null;
        }
        if (node.value < l) {
            return trimBST(node.right, l, r);
        }
        if (node.value > r) {
            return trimBST(node.left, l, r);
        }
        trimBST(node.left, l, r);
        trimBST(node.right, l, r);
        return node;
    }

    public static void main(String[] args) {

    }
}
