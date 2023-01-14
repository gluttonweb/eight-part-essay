package eightpartessay;

/**
 * 买卖股票的最佳时机含冷冻期（动态规划）
 * 1. ⚠️确定dp数组（dp table）以及下标的含义：️dp[i][j]中 i表示第i天 j=0 表示
 * dp[i][0]表示买入股票状态（今天买入股票，或者是之前就买入了股票然后没有操作）所得最大现金
 * dp[i][1]表示两天前就卖出了股票，度过了冷冻期，一直没操作，今天保持卖出股票状态所得最大现金
 * dp[i][2]表示今天卖出了股票所得最大现金
 * dp[i][3]表示处于冷冻期（但冷冻期状态不可持续，只有一天）所得最大现金
 * 2. 确定递推公式：
 * dp[i][0] = max(dp[i - 1][0], dp[i-1][1] - prices[i], dp[i-1][3] - prices[i])
 * dp[i][1] = max(dp[i - 1][1], dp[i-1][3])(表示昨天刚冷冻期结束，或昨天已经冷冻期结束)
 * dp[i][2] = max(dp[i - 1][0] + prices[i])（昨天一定是买入股票状态，今天卖出）
 * dp[i][3] = max(dp[i - 1][2])
 * 3. dp数组如何初始化:
 * dp[0][0] = -prices[0] dp[0][1] = 0 dp[0][2] = 0 dp[0][3] = 0
 * 4. 确定遍历顺序: 从递归公式上可以看出，dp[i] 依赖于 dp[i-1]，所以是从前向后遍历。
 * 5. 举例推导dp数组：以下
 */
public class BestTime2BuySellStockWithCD {

    public static int bestTime2BuySellStockWithCD(int[] stocks) {
        int length = stocks.length;
        int[][] dp = new int[length][4];
        // 初始化
        dp[0][0] = -stocks[0];
        dp[0][1] = 0;
        dp[0][2] = 0;
        dp[0][3] = 0;
        for (int i = 1; i < stocks.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], Math.max(dp[i - 1][1], dp[i - 1][3]) - stocks[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][3]);
            dp[i][2] = dp[i - 1][0] + stocks[i];
            dp[i][3] = dp[i - 1][2];
        }
        return Math.max(dp[length - 1][1], Math.max(dp[length - 1][2], dp[length - 1][3]));
    }


    public static void main(String[] args) {
        int[] stocks = {7, 6, 10, 9, 10, 1, 2, 3};
        int maxValue = bestTime2BuySellStockWithCD(stocks);
        System.out.println(maxValue);
    }
}
