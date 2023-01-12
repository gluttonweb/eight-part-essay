package eightpartessay;

/**
 * 买卖股票的最佳时机II（动态规划）
 * 与I不同的是股票可以多次买卖，相应的 ⚠️解法区别主要是体现在递推公式上
 * 1. 确定dp数组（dp table）以及下标的含义：️dp[i][0] 表示第i天持有股票所得（最多）现金；dp[i][1] 表示第i天不持有股票所得（最多）现金
 * 2. 确定递推公式：️dp[i][0] = max(dp[i - 1][0], dp[i - 1][1] - prices[i]); dp[i][1] = max(dp[i - 1][1], dp[i - 1][0] + prices[i])
 * （如果第i天持有股票即dp[i][0]， 那么可以由两个状态推出来：
 * 第i-1天就持有股票，那么就保持现状，所得现金就是昨天持有股票的所得现金 即：dp[i - 1][0]
 * 第i天买入股票，所得现金就是买入昨天持有股票减去今天的股票后所得现金即：dp[i - 1][1] - prices[i]
 * 那么dp[i][0]应该选所得现金最大的，所以dp[i][0] = max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
 * 如果第i天不持有股票即dp[i][1]， 也可以由两个状态推出来：
 * 第i-1天就不持有股票，那么就保持现状，所得现金就是昨天不持有股票的所得现金 即：dp[i - 1][1]
 * 第i天卖出股票，所得现金就是按照今天股票佳价格卖出后所得现金即：prices[i] + dp[i - 1][0]
 * 同样dp[i][1]取最大的，dp[i][1] = max(dp[i - 1][1], dp[i - 1][0] + prices[i])）
 * 3. dp数组如何初始化: dp[0][0] = - price[0]；dp[0][1] = 0；
 * （由递推公式可以看出基础都是要从dp[0][0]和dp[0][1]推导出来。那么dp[0][0]表示第0天持有股票，此时的持有股票就一定是买入股票了，
 * 因为不可能有前一天推出来，所以dp[0][0] -= prices[0]; dp[0][1]表示第0天不持有股票，不持有股票那么现金就是0，所以dp[0][1] = 0;）
 * 4. 确定遍历顺序: 从递推公式可以看出dp[i]都是有dp[i - 1]推导出来的，那么一定是从前向后遍历
 * 5. 举例推导dp数组：以下
 */
public class BestTime2BuySellStock2 {


    public static int bestTime2BuySellStock2(int[] stocks) {
        int length = stocks.length;
        int[][] dp = new int[length][2];
        // 初始化
        dp[0][0] = -stocks[0];
        dp[0][1] = 0;
        for (int i = 1; i < stocks.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - stocks[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + stocks[i]);
        }
        return dp[length - 1][1];
    }


    public static void main(String[] args) {
        int[] stocks = {7, 6, 10, 9, 10, 1, 2, 3};
//        int maxValue = bestTime2BuySellStock(stocks);
        int maxValue = bestTime2BuySellStock2(stocks);
        System.out.println(maxValue);
    }
}
