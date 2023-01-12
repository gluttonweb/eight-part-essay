package eightpartessay;

/**
 * 分割等和子集（类0-1背包）
 * 这道题目是要找是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * 那么只要找到集合里能够出现 sum / 2 的子集总和，就算是可以分割成两个相同元素和子集了。类似背包问题，直接上01背包问题解法
 * 一 双指针解法：
 * 1. 确定dp数组（dp table）以及下标的含义：dp[i][j] 表示从下标为[0-i]的数组中任意取，放进总和为j的背包
 * 2. 确定递推公式：dp[i][j] = max(dp[i-1][j], dp[i-1][j-num[i]] + num[i])
 * 3. dp数组如何初始化: p[i][0] = 0；当取第0个数时，即dp[0][j]时，当j < num[0], dp[0][j] = 0, 当j >= num[0], dp[0][j] = num[0]
 * 4. 确定遍历顺序: 有两个遍历的维度：物品与背包重量，先遍历 物品还是先遍历背包重量呢，其实都可以，先遍历物品更好理解
 * 5. 举例推导dp数组：以下
 * 二 单指针解法：
 * 1. 确定dp数组（dp table）以及下标的含义：dp[j] 表示背包能装下物品最大价值为j
 * 2. 确定递推公式：dp[j] = max(dp[j], dp[j-num[i]] + num[i])
 * 3. dp数组如何初始化: dp[0] = 0
 * 4. 确定遍历顺序: 有两个遍历的维度：物品与背包重量，正序遍历物品，倒叙遍历背包容量
 * 5. 举例推导dp数组：以下
 */
public class PartitionEqualSumSubset {

    /**
     * 背包问题解决方案1:双指针
     *
     * @param num
     * @return
     */
    public static boolean partitionEqualSumSubset(int[] num) {
        // 求sum / 2 的子集总和
        int target = getEqualSubsetSum(num);
        System.out.println("target=" + target);
        int length = num.length - 1;
        int[][] dp = new int[length][target + 1];
        for (int i = 0; i < length; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i <= target; i++) {
            if (target < num[0]) {
                dp[0][i] = 0;
                continue;
            }
            dp[0][i] = num[0];
        }
        for (int i = 1; i < length; i++) {
            for (int k = 1; k <= target; k++) {
                if (k < num[i]) {
                    dp[i][k] = dp[i - 1][k];
                    continue;
                }
                dp[i][k] = Math.max(dp[i - 1][k], dp[i - 1][k - num[i]] + num[i]);
                if (dp[i][k] == target) {
                    System.out.println(true);
                    return true;
                }
            }
        }
        System.out.println(false);
        return false;
    }

    /**
     * 背包问题解决方案2:单指针
     *
     * @param num
     * @return
     */
    public static boolean partitionEqualSumSubset2(int[] num) {
        // 求sum / 2 的子集总和
        int target = getEqualSubsetSum(num);
        if (target == 0) {
            return false;
        }
        int goodsSize = num.length;
        int[] dp = new int[target + 1];
        dp[0] = 0;
        for (int i = 0; i < goodsSize; i++) {
            for (int j = target; j > 0; j--) {
                if (j < num[i]) {
                    dp[j] = dp[j];
                    continue;
                }
                dp[j] = Math.max(dp[j], dp[j - num[i]] + num[i]);
                if (dp[j] == target) {
                    System.out.println(true);
                    return true;
                }
            }
        }
        System.out.println(false);
        return false;
    }

    /**
     * 计算等和子集总和
     *
     * @param num
     * @return
     */
    public static int getEqualSubsetSum(int[] num) {
        // 求sum / 2 的子集总和
        int sum = 0;
        for (int i : num) {
            sum = sum + i;
        }
        if (sum % 2 != 0) {
            return 0;
        }
        int target = sum / 2;
        System.out.println("target=" + target);
        return target;
    }

    public static void main(String[] args) {
        int[] num = {1, 5, 11, 5};
        partitionEqualSumSubset(num);
    }
}
