package eightpartessay;

/**
 * 最小代价爬楼梯（典型动态规划）
 * 1. 确定dp数组（dp table）以及下标的含义：dp[i] 表示爬到第i级楼梯所需体力
 * 2. 确定递推公式：dp[i] = min(dp[i-1]+cost[i-1], dp[i-2]+cost[i-2])
 * 3. dp数组如何初始化: dp0 = 0, dp1 = 0
 * 4. 确定遍历顺序: 从前往后遍历
 * 5. 举例推导dp数组：以下
 */
public class MinCostClimbingStairs {

    public static void main(String[] args) {
        int dp0 = 0;
        int dp1 = 1;
        int dpi = 0;
        int[] stairs = {1, 10, 1, 100, 10, 1, 100, 1};
        for (int i = 0; i < stairs.length; i++) {
            if (i == 0 || i == 1) {
                dpi = 0;
                continue;
            }
            dpi = min(dp0 + stairs[i - 2], dp1 + stairs[i - 1]);
            dp0 = dp1;
            dp1 = dpi;
        }
        System.out.println(dpi);
    }

    public static int min(Integer a, Integer b) {
        return a.compareTo(b) < 0 ? a : b;
    }
}
