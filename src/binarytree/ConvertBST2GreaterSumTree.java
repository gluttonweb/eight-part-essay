package binarytree;

/**
 * 将二叉搜索树转换为累加树（更大和树）
 * 分析：反中序遍历累加
 */
public class ConvertBST2GreaterSumTree {

    private static Integer sum;

    public static void convertBST2GreaterSumTree(TreeNode bst) {
        if (null == bst) {
            return;
        }
        // 反中序遍历
        convertBST2GreaterSumTree(bst.right);
        sum += bst.value;
        bst.value = sum;
        convertBST2GreaterSumTree(bst.left);
    }

    public static void main(String[] args) {

    }
}
