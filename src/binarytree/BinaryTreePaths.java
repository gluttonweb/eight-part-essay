package binarytree;

import java.util.List;

/**
 * 二叉树的所有路径
 * ⚠️注意递归和回溯的处理顺序
 */
public class BinaryTreePaths {
    /**
     * @param node  二叉树根结点
     * @param paths 二叉树所有路径
     * @param nodes 记录每条二叉树路径经过的节点集合
     * @return
     */
    public static List<String> binaryTreePaths(TreeNode node, List<String> paths, List<Object> nodes) {
        if (null == node) {
            return null;
        }
        nodes.add(node.value);
        if (null == node.left && null == node.right) {
            StringBuffer sb = new StringBuffer();
            for (Object eachNode : nodes) {
                sb.append(eachNode).append("->");
            }
            paths.add(sb.toString());
        }
        if (null != node.left) {
            binaryTreePaths(node.left, paths, nodes); // 递归
            paths.remove(paths.size() - 1); // 回溯
        }
        if (null != node.right) {
            binaryTreePaths(node.right, paths, nodes); // 递归
            paths.remove(paths.size() - 1); // 回溯
        }
        return paths;
    }

}
