package binarytree;

/**
 * 二叉搜索数的插入操作
 * 分析：只要遍历二叉搜索树，找到空节点，插入元素就可以了
 */
public class InsertIntoBST {

    public static TreeNode insertIntoBST(TreeNode node, Integer insertValue) {
        if (null == node) {
            return new TreeNode(insertValue);
        }
        if (insertValue > node.value) {
            node.right = insertIntoBST(node.right, insertValue);
        } else {
            node.left = insertIntoBST(node.left, insertValue);
        }
        return node;
    }

    public static void main(String[] args) {

    }
}
