package binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 层序遍历
 */
public class LevelTraversal {
    /**
     * 递归方式-DFS
     */
    public static List<List<Object>> levelTraversal(TreeNode node, int deep) {
        List<List<Object>> resultList = new ArrayList<>();
        if (null == node) {
            return resultList;
        }
        deep++;
        if (resultList.size() < deep) {
            List<Object> levelList = new ArrayList<>();
            resultList.add(levelList);
        }
        resultList.get(deep - 1).add(node.value);
        levelTraversal(node.left, deep);
        levelTraversal(node.right, deep);
        return resultList;
    }

    /**
     * 迭代方式-BFS
     */
    public static void levelTraversal(TreeNode node) {
        List<List<Object>> resultList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (null == node) {
            return;
        }
        queue.offer(node);
        while (!queue.isEmpty()) {
            List<Object> levelList = new ArrayList<>();
            int queueLength = queue.size();
            while (queueLength > 0) {
                TreeNode pollNode = queue.poll();
                levelList.add(pollNode.value);
                if (null != pollNode.left) {
                    queue.offer(pollNode.left);
                }
                if (null != pollNode.right) {
                    queue.offer(pollNode.right);
                }
                queueLength--;
            }
        }
    }

    public static void main(String[] args) {

    }
}
