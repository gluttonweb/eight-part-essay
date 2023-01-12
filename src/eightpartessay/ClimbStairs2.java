package eightpartessay;

/**
 * 爬楼梯进阶版 （类完全背包问题）
 * 1. 确定dp数组（dp table）以及下标的含义：dp[j] 表示爬到有i个台阶的楼顶，有dp[i]种方法
 * 2. 确定递推公式：dp[i] += dp[i - j]，
 * (求装满背包有几种方法，递推公式一般都是dp[i] += dp[i - nums[j]];
 * 本题呢，dp[i]有几种来源，dp[i - 1]，dp[i - 2]，dp[i - 3] 等等，即：dp[i - j])
 * 3. dp数组如何初始化: dp[0] = 1；
 * (从dp[i]的含义上来讲就是，凑成总金额0的货币组合数为1)
 * 4. 确定遍历顺序: 先外层for循环遍历背包（总台阶数），内层for遍历物品（每次上的台阶）
 * （⚠️如果求组合数就是外层for循环遍历物品，内层for遍历背包。如果求排列数就是外层for遍历背包，内层for循环遍历物品。）
 * 5. 举例推导dp数组：以下
 */
public class ClimbStairs2 {

    public static int climbStairs2(int m, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int j = 0; j <= target; j++) {
            for (int i = 0; i < m; i++) {
                if (j < i) {
                    continue;
                }
                dp[j] += dp[j - i];
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        int m = 5;
        int target = 10;
        int ways = climbStairs2(m, target);
        System.out.println(ways);
    }

}
