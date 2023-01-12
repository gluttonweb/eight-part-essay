package eightpartessay;

/**
 * 目标和（类0-1背包问题）
 * <p>
 * 如何转化为01背包问题呢。假设加法的总和为x，那么减法对应的总和就是sum - x。所以我们要求的是 x - (sum - x) = S。x = (S + sum) / 2
 * ⚠️此时问题就转化为，装满容量为x背包，有几种方法。
 * <p>
 * 1. 确定dp数组（dp table）以及下标的含义：dp[j] 表示填满j（包括j）这么大容积的包，有dp[j]种方法
 * 2. 确定递推公式：dp[j] = dp[j] + dp[j-num[i]] 即 dp[j] += dp[j-num[i]]
 * ⚠️(由两个方向推出来dp[j]：1 不放物品i：dp[j]有dp[j]种方案；2 放物品i dp[j] 有dp[j-num[i]种方案, 所以dp[j]一共有dp[j] + dp[j-num[i]种方案）
 * 3. dp数组如何初始化: dp[0] = 1 即填满容量为0的包 需要1中方法：放0
 * 4. 确定遍历顺序: 二维dp遍历的时候，背包容量是从小到大，而一维dp遍历的时候，背包是从大到小。
 * 倒序遍历是为了保证物品i只被放入一次！如果正序遍历了，那么物品0就会被重复加入多次，可自行测试
 * 5. 举例推导dp数组：以下
 */
public class FindTargetSumWays {

    public static void main(String[] args) {
        int[] num = {1, 1, 1, 1, 1};
        int s = 3;
        int ways = findTargetSumWays(num, s);
        System.out.println(ways);
    }

    public static int findTargetSumWays(int[] num, int s) {

        // x = (S + sum) / 2 ，若(S + sum) / 2有余数 则无解
        int sum = sum(num);
        if ((s + sum) % 2 != 0) {
            return 0;
        }
        // 若 s大于 sum，则也无解
        if (s > sum) {
            return 0;
        }
        int bagSize = (s + sum) / 2;
        int[] dp = new int[bagSize + 1];
        int length = num.length;

        // 初始化
        dp[0] = 1;
        int ways = 0;
        for (int i = 0; i < length; i++) {
            for (int j = bagSize; j >= num[i]; j--) {
                dp[j] += dp[j - num[i]];
            }
        }
        return dp[bagSize];
    }

    /**
     * 求数组总和
     *
     * @param num
     * @return
     */
    public static int sum(int[] num) {
        int sum = 0;
        for (int i : num) {
            sum = sum + i;
        }
        return sum;
    }

}
