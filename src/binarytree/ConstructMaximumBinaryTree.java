package binarytree;

/**
 * 最大二叉树
 */
public class ConstructMaximumBinaryTree {

    public static void constructMaximumBinaryTree(int[] nums, TreeNode node, Integer startIndex, Integer endIndex) {
        if (startIndex > endIndex) {
            return;
        }
        Integer maxIndex = startIndex;
        // 找出数组中最大的作为根结点
        for (int i = startIndex; i <= endIndex; i++) {
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }
        node.setValue(nums[maxIndex]);

        if (null == node.left) {
            node.left = new TreeNode();
        }
        constructMaximumBinaryTree(nums, node.left, startIndex, maxIndex - 1);
        if (null == node.right) {
            node.right = new TreeNode();
        }
        constructMaximumBinaryTree(nums, node.right, maxIndex + 1, endIndex);
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 6, 0, 5};
        TreeNode root = new TreeNode();
        constructMaximumBinaryTree(nums, root, 0, nums.length - 1);
    }
}
