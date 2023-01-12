package eightpartessay;

/**
 * 买卖股票的最佳时机IV（动态规划）
 * 买卖股票的最佳时机III的升级版
 * 1. 确定dp数组（dp table）以及下标的含义：️dp[i][j]中 i表示第i天，j为j次交易，dp[i][j]表示第i天第j次交易所剩最大现金。
 * 2. 确定递推公式：
 * j为奇数为购买 dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - 1] - prices[i]);
 * j为偶数为出售 dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - 1] + prices[i])。
 * ️（由dp[i][1] = max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
 * dp[i][2] = max(dp[i - 1][2], dp[i - 1][1] + prices[i]);
 * dp[i][3] = max(dp[i - 1][3], dp[i - 1][2] - prices[i]);
 * dp[i][4] = max(dp[i - 1][4], dp[i - 1][3] + prices[i])推出）;
 * 3. dp数组如何初始化:
 * j为奇数  dp[0][j] = -prices[0]；
 * j为偶数，dp[0][j] = 0；
 * （由dp[0][0] = 0；dp[0][1] = -prices[0]；dp[0][2] = 0；dp[0][3] = -prices[0]; dp[0][4] = 0推出）
 * 4. 确定遍历顺序: 从递推公式可以看出dp[i]都是有dp[i - 1]推导出来的，那么一定是从前向后遍历
 * 5. 举例推导dp数组：以下
 */
public class BestTime2BuySellStock4 {

    public static int bestTime2BuySellStock4(int[] stocks, int k) {
        int length = stocks.length;
        int[][] dp = new int[length][2 * k + 1];
        // 初始化
        for (int j = 0; j < 2 * k + 1; j++) {
            if (j % 2 == 0) {
                dp[0][j] = 0;
            } else {
                dp[0][j] = -stocks[0];
            }
        }
        for (int i = 1; i < stocks.length; i++) {
            for (int j = 1; j < 2 * k + 1; j++) {
                if (j % 2 == 0) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] + stocks[i]);
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] - stocks[i]);
                }
            }

        }
        return dp[length - 1][2 * k];
    }


    public static void main(String[] args) {
        int[] stocks = {7, 6, 10, 9, 10, 1, 2, 3};
        int k = 2;
        int maxValue = bestTime2BuySellStock4(stocks, 2);
        System.out.println(maxValue);
    }
}
