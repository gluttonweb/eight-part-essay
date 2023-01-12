package review;

/**
 * 最小代价爬楼梯（典型动态规划）
 * 1. 确定dp数组（dp table）以及下标的含义：dp[i] 代表爬到第i阶楼梯所花费的最小体力
 * 2. 确定递推公式：dp[i] = min(dp[i-1] + cost[i-1], dp[i-2] + cost[i-2])
 * 3. dp数组如何初始化: dp[0] = 0 dp[i] = 0
 * 4. 确定遍历顺序: 从前往后遍历
 * 5. 举例推导dp数组：以下
 */
public class MinCostClimbingStairs {

    public static void main(String[] args) {

    }

    public static int min(Integer a, Integer b) {
        return a.compareTo(b) < 0 ? a : b;
    }
}
