package eightpartessay;

/**
 * 零钱兑换II (完全背包)
 * 1. 确定dp数组（dp table）以及下标的含义：dp[j] 表示凑成总金额j的货币组合数
 * 2. 确定递推公式：dp[j] += dp[j - coins[i]]
 * (dp[j] （考虑coins[i]的组合总和） 就是所有的dp[j - coins[i]]（不考虑coins[i]）相加。参考：{@link FindTargetSumWays})
 * 3. dp数组如何初始化: dp[0] = 1；
 * (从dp[i]的含义上来讲就是，凑成总金额0的货币组合数为1)
 * 4. 确定遍历顺序: 先外层for循环遍历物品（钱币），内层for遍历背包（金钱总额）
 * （⚠️外层for循环遍历物品（钱币），内层for遍历背包（金钱总额）的情况，这种遍历顺序中dp[j]里计算的是组合数！
 * ️外层for循环遍历背包（金钱总额），内层for遍历物品（钱币），这种遍历顺序中dp[j]里计算的是排列数！）
 * 5. 举例推导dp数组：以下
 */
public class Change2 {

    public static int change(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j < coins[i]) {
                    continue;
                }
                dp[j] += dp[j - coins[i]];
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 5;
        int ways = change(coins, amount);
        System.out.println(ways);
    }
}
