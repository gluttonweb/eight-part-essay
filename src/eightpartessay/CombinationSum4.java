package eightpartessay;

/**
 * 组合总和IV（类完全背包问题）
 * 1. 确定dp数组（dp table）以及下标的含义：dp[j] 表示凑成总数j的排列数
 * 2. 确定递推公式：dp[j] += dp[j - nums[i]]
 * (dp[j] （考虑nums[i]的组合总和） 就是所有的dp[j - nums[i]]（nums[i]）相加。参考：{@link FindTargetSumWays})
 * 3. dp数组如何初始化: dp[0] = 1；
 * (从dp[i]的含义上来讲就是，凑成总金额0的货币组合数为1)
 * 4. 确定遍历顺序: 先外层for循环遍历背包（总数），内层for遍历物品（数组中的数字）
 * （⚠️如果求组合数就是外层for循环遍历物品，内层for遍历背包。如果求排列数就是外层for遍历背包，内层for循环遍历物品。）
 * 5. 举例推导dp数组：以下
 */
public class CombinationSum4 {

    public static int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int j = 0; j <= target; j++) {
            for (int i = 0; i < nums.length; i++) {
                if (j < nums[i]) {
                    continue;
                }
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int target = 4;
        int ways = combinationSum4(nums, target);
        System.out.println(ways);
    }
}
