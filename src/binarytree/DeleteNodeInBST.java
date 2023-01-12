package binarytree;

/**
 * 删除二叉搜索树中的节点
 * 分析：
 * 第一种情况：没找到删除的节点，遍历到空节点直接返回了
 * 找到删除的节点
 * 第二种情况：左右孩子都为空（叶子节点），直接删除节点， 返回NULL为根节点
 * 第三种情况：删除节点的左孩子为空，右孩子不为空，删除节点，右孩子补位，返回右孩子为根节点
 * 第四种情况：删除节点的右孩子为空，左孩子不为空，删除节点，左孩子补位，返回左孩子为根节点
 * 第五种情况：⚠️左右孩子节点都不为空，则将删除节点的左子树头结点（左孩子）放到删除节点的右子树的最左面节点的左孩子上，返回删除节点右孩子为新的根节点。
 */
public class DeleteNodeInBST {
    public static TreeNode deleteNodeInBST(TreeNode node, Integer deleteNode) {
        if (null == node) {
            return null;
        }
        if (deleteNode > node.value) {
            TreeNode leftNode = deleteNodeInBST(node.left, deleteNode);
        } else if (deleteNode < node.value) {
            TreeNode rightNode = deleteNodeInBST(node.right, deleteNode);
        } else if (deleteNode == node.value) {
            // 左右孩子为空,直接删除
            if (null == node.left && null == node.right) {
                return null;
            } else if (null == node.left && null != node.right) {
                return node.right;
            } else if (null != node.left && null == node.right) {
                return node.left;
            } else if (null != node.left && null != node.right) {
                // ⚠️将删除节点的左子树的头节点放到删除节点右子树的最左面节点的左孩子上，返回删除节点的右孩子节点
                TreeNode tempLeft = node.right.left;
                while (null != tempLeft.left) {
                    tempLeft = tempLeft.left;
                }
                tempLeft = node.left;
                node = node.right;
                return node;
            }
        }
        return node;
    }

    public static void main(String[] args) {

    }
}
