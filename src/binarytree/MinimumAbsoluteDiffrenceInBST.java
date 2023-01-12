package binarytree;

import java.util.LinkedList;

/**
 * 二叉搜索树的最小绝对差
 * ⚠️使用中序遍历出来的数组正好是有序数组，只需求最小的相邻数之间的差值即可
 */
public class MinimumAbsoluteDiffrenceInBST {


    public static void inorderTraversal(TreeNode node, LinkedList inorderList) {
        if (null == node) {
            return;
        }
        inorderTraversal(node.left, inorderList);
        inorderList.add(node.value);
        inorderTraversal(node.right, inorderList);
    }

    public static int minimumAbsoluteDiffrenceInBST(TreeNode node) {
        LinkedList<Integer> inorderList = new LinkedList<>();
        inorderTraversal(node, inorderList);
        Integer min = Integer.MAX_VALUE;
        for (int i = 1; i < inorderList.size(); i++) {
            min = Math.min(min, inorderList.get(i) - inorderList.get(i - 1));
        }
        return min;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        minimumAbsoluteDiffrenceInBST(root);
    }
}
