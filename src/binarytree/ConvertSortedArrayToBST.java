package binarytree;

/**
 * 将有序数组转换为二叉搜索树
 * 分析：根据数组构造一棵二叉树，本质就是寻找分割点，分割点作为当前节点，然后递归左区间和右区间。
 * 分割点就是数组中间位置的节点。如果数组长度为偶数，中间节点有两个，取哪一个？取哪一个都可以，只不过构成了不同的平衡二叉搜索树。
 */
public class ConvertSortedArrayToBST {

    public static void converSortedArrayToBST(TreeNode node, int[] sortedArray, int startIndex, int endIndex) {
        if (endIndex < startIndex || startIndex < 0 || endIndex < 0) {
            return;
        }
        if (startIndex == endIndex) {
            node.setValue(sortedArray[startIndex]);
            return;
        }
        // 取中间节点
        int centorIndex = startIndex + ((endIndex - startIndex) / 2);
        node.setValue(sortedArray[centorIndex]);
        if (null == node.left) {
            node.left = new TreeNode();
        }
        converSortedArrayToBST(node.left, sortedArray, startIndex, centorIndex - 1);
        if (null == node.right) {
            node.right = new TreeNode();
        }
        converSortedArrayToBST(node.right, sortedArray, centorIndex + 1, endIndex);
    }

    public static void main(String[] args) {
//        System.out.println(7 / 2);
        TreeNode root = new TreeNode();
        int[] sortedArray = {-10, -3, 0, 5, 9};
        converSortedArrayToBST(root, sortedArray, 0, sortedArray.length - 1);
        System.out.println(root);
    }
}
