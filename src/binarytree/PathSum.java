package binarytree;

import java.util.List;

/**
 * 路径总和
 */
public class PathSum {

    public static void traversal(TreeNode node, List<Integer> pathNodes, List<Integer> pathSums) {
        if (null == node) {
            return;
        }
        pathNodes.add((Integer) node.value);
        if (null == node.left && null == node.right) { // 叶子节点
            Integer pathSum = 0;
            for (Integer pathNodeValue : pathNodes) {
                pathSum += pathNodeValue;
                pathSums.add(pathSum);
            }
            return;
        }
        if (null != node.left) {
            traversal(node.left, pathNodes, pathSums);
            pathNodes.remove(pathNodes.size() - 1);
        }
        if (null != node.right) {
            traversal(node.right, pathNodes, pathSums);
            pathNodes.remove(pathNodes.size() - 1);
        }
    }

    public static boolean pathSum(TreeNode node, List<Integer> pathNodes, List<Integer> pathSums, int target) {
        traversal(node, pathNodes, pathSums);
        return pathSums.stream().anyMatch(sum -> sum.equals(target));
    }

    public static void main(String[] args) {

    }
}
