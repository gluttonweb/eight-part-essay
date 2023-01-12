package binarytree;

/**
 * 从中序和后序序列构造二叉树
 * 第一步：如果数组大小为零的话，说明是空节点了
 * 第二步：如果不为空，那么取后序数组最后一个元素即为根结点
 * 第三步：找到根结点在中序数组的位置，作为切割点
 * 第四步：切割中序数组，切成中序左数组和中序右数组 （顺序别搞反了，一定是先切中序数组）
 * 第五步：切割后序数组，切成后序左数组和后序右数组
 * 第六步：递归处理左区间和右区间
 * <p>
 * 从前序和中序序列构造二叉树 （类似）
 * 1 取前序数组第一个元素即为根节点
 * 2 找到根结点在中序数组的位置，作为切割点
 * 3 切割中序数组，切成中序左数组和中序右数组
 * 4 切割后序数组，切成后序左数组和后序右数组
 * 5 递归处理
 */
public class $BuildTree {

    public static void buildTree(int[] inorder, int[] postorder, TreeNode node) {
        // todo 记录原始中序数组位置 递归时判断剩余数组
//        if (inorder.length == 0) {
//            return;
//        }
        System.out.println(postorder.length);
        // 1 获取后序数组最后一个节点即为根结点
        int rootValue = postorder[postorder.length - 1];
        node.setValue(rootValue);
        if (inorder.length == 1) { // 数组切割到只剩一个元素，setValue后直接返回
            return;
        }
        // 2 找到根结点在中序数组的位置，作为切割点
        int centorIndex = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootValue) {
                centorIndex = i;
                break;
            }
        }
        // 3 切割中序数组，切成中序左数组和中序右数组
        int[] leftInorderArray = new int[centorIndex];
        int[] rightInorderArray = new int[inorder.length - centorIndex - 1];
        for (int i = 0; i < inorder.length; i++) {
            if (i < centorIndex) {
                leftInorderArray[i] = inorder[i];
            }
            if (i > centorIndex) {
                rightInorderArray[i - leftInorderArray.length - 1] = inorder[i];
            }
        }
        // 4 切割后序数组，切成后序左数组和后序右数组
        for (int i = 0; i < postorder.length - 1; i++) {
            if (postorder[i] == leftInorderArray[leftInorderArray.length - 1]) {
                centorIndex = i;
            }
        }
        int[] leftPostorderArray = new int[centorIndex];
        int[] rightPostorderArray = new int[postorder.length - centorIndex - 1];
        for (int i = 0; i < postorder.length; i++) {
            if (i < centorIndex) {
                leftPostorderArray[i] = postorder[i];
            }
            if (i > centorIndex) {
                rightPostorderArray[i - leftPostorderArray.length - 1] = postorder[i];
            }
        }
        // 5 递归
        if (null == node.left) {
            node.left = new TreeNode();
        }
        buildTree(leftInorderArray, leftPostorderArray, node.left);
        if (null == node.right) {
            node.right = new TreeNode();
        }
        buildTree(rightInorderArray, rightPostorderArray, node.right);
    }

    public static void main(String[] args) {
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};
        TreeNode root = new TreeNode();
        buildTree(inorder, postorder, root);
    }
}
