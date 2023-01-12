package eightpartessay;

/**
 * 零钱兑换 （类完全背包）
 * 1. 确定dp数组（dp table）以及下标的含义：dp[j] 表示凑成总金额所需的最少的硬币个数
 * 2. 确定递推公式：dp[j] = Min(dp[j],dp[j - coins[i]] + 1)
 * 3. dp数组如何初始化: dp[0] = 0；⚠️考虑到递推公式的特性，dp[j]必须初始化为一个最大的数，
 * 否则就会在min(dp[j - coins[i]] + 1, dp[j])比较的过程中被初始值覆盖。
 * 4. 确定遍历顺序: 先外层for循环遍历物品（钱币），内层for遍历背包（金钱总额）
 * 5. 举例推导dp数组：以下
 */
public class Change {

    public static int change(int[] coins, int target) {
        int[] dp = new int[target + 1];
        // 初始化
        int max = Integer.MAX_VALUE;
        for (int j = 1; j < dp.length; j++) {
            dp[j] = max;
        }
        dp[0] = 0;

        for (int i = 0; i < coins.length; i++) {
            for (int j = 1; j <= target; j++) {
                if (j < coins[i]) {
                    continue;
                }
                dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int target = 11;
        int minCoinNum = change(coins, target);
        System.out.println(minCoinNum);
    }
}
