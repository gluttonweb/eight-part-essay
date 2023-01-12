package eightpartessay;

/**
 * 买卖股票的最佳时机III（动态规划）
 * 1. 确定dp数组（dp table）以及下标的含义：️dp[i][j]中 i表示第i天，j为 [0 - 4] 五个状态，dp[i][j]表示第i天状态j所剩最大现金。
 * （一天一共就有五个状态，0 没有操作；1 第一次买入；2 第一次卖出；3 第二次买入；4 第二次卖出）
 * 2. 确定递推公式：️dp[i][1] = max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
 *                dp[i][2] = max(dp[i - 1][2], dp[i - 1][1] + prices[i]);
 *                dp[i][3] = max(dp[i - 1][3], dp[i - 1][2] - prices[i]);
 *                dp[i][4] = max(dp[i - 1][4], dp[i - 1][3] + prices[i]);
 * （达到dp[i][1]状态，有两个具体操作：
 * 操作一：第i天买入股票了，那么dp[i][1] = dp[i-1][0] - prices[i]
 * 操作二：第i天没有操作，而是沿用前一天买入的状态，即：dp[i][1] = dp[i - 1][1]
 * 一定是选最大的，所以 dp[i][1] = max(dp[i-1][0] - prices[i], dp[i - 1][1]);
 * 同理dp[i][2]也有两个操作：
 * 操作一：第i天卖出股票了，那么dp[i][2] = dp[i - 1][1] + prices[i]
 * 操作二：第i天没有操作，沿用前一天卖出股票的状态，即：dp[i][2] = dp[i - 1][2]
 * 所以dp[i][2] = max(dp[i - 1][1] + prices[i], dp[i - 1][2])
 * 同理可推出剩下状态部分）
 * 3. dp数组如何初始化: dp[0][0] = 0；dp[0][1] = -prices[0]；dp[0][2] = 0；dp[0][3] = -prices[0]; dp[0][4] = 0
 * 4. 确定遍历顺序: 从递推公式可以看出dp[i]都是有dp[i - 1]推导出来的，那么一定是从前向后遍历
 * 5. 举例推导dp数组：以下
 */
public class BestTime2BuySellStock3 {


    public static int bestTime2BuySellStock3(int[] stocks) {
        int length = stocks.length;
        int[][] dp = new int[length][5];
        // 初始化
        dp[0][0] = 0;
        dp[0][1] = -stocks[0];
        dp[0][2] = 0;
        dp[0][3] = -stocks[0];
        dp[0][4] = 0;
        for (int i = 1; i < stocks.length; i++) {
            dp[i][0] = 0;
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - stocks[i]);
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] + stocks[i]);
            dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] - stocks[i]);
            dp[i][4] = Math.max(dp[i - 1][4], dp[i - 1][3] + stocks[i]);
        }
        return dp[length - 1][4];
    }


    public static void main(String[] args) {
        int[] stocks = {7, 6, 10, 9, 10, 1, 2, 3};
//        int maxValue = bestTime2BuySellStock(stocks);
        int maxValue = bestTime2BuySellStock3(stocks);
        System.out.println(maxValue);
    }
}
