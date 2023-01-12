package eightpartessay;

/**
 * 最后一块石头的重量（类0-1背包问题）
 * 本题其实就是尽量让石头分成重量相同的两堆，相撞之后剩下的石头最小，这样就化解成01背包问题了。类似分割等和子集。
 * 1. 确定dp数组（dp table）以及下标的含义：dp[i][j] 表示从下标为[0-i]的石头里任意取，放进容量为j的背包，重量最接近j(dp[i][j])
 * 2. 确定递推公式：dp[i][j] = max(dp[i-1][j], dp[i-1][j-wight[i]] + value[i])
 * (由两个方向推出来dp[i][j]：1 不放物品i：dp[i][j] = dp[i-1][j]) 2 放物品i dp[i][j] = dp[i-1][j-wight[i]] + value[i]
 * 3. dp数组如何初始化:
 * 首先当背包重量为0时，背包能容纳的最大价值为0，即dp[i][0] = 0；
 * 其次当第0个物品时，即dp[0][j]时，当j < wight[0], dp[0][j] = 0, 当j >= wight[0], dp[0][j] = value[0]
 * 4. 确定遍历顺序: 有两个遍历的维度：物品与背包重量，先遍历 物品还是先遍历背包重量呢，其实都可以，先遍历物品更好理解
 * 5. 举例推导dp数组：以下
 */
public class LastStoneWeight {

    /**
     * 双指针解法
     *
     * @param stone
     */
    public static void lastStoneWeight(int[] stone) {
        // 求等和子集总和
        int target = getEqualSubsetSum(stone);
        int goodsSize = stone.length;
        int[][] dp = new int[goodsSize][target + 1];
        int max = 0;
        // 初始化
        for (int i = 0; i < goodsSize; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j <= target; j++) {
            if (j < stone[0]) {
                dp[0][j] = 0;
                continue;
            }
            dp[0][j] = stone[0];
        }
        for (int i = 1; i < goodsSize; i++) {
            for (int j = 1; j <= target; j++) {
                if (j < stone[i]) {
                    dp[i][j] = dp[i - 1][j];
                    continue;
                }
                dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - stone[i]] + stone[i]);
                System.out.println("dp" + i + j + "=" + dp[i][j]);
                if (dp[i][j] > max) {
                    max = dp[i][j];
                }
            }
        }
        int lastStone = sum(stone) - max * 2;
        System.out.println(lastStone);
    }

    /**
     * 单指针解法
     * 递归公式：dp[j] = max(dp[j], dp[j-stones[i]] + stones[i])
     * 初始化：dp[0] = 0
     *
     * @param stones
     */
    public static int lastStoneWeight2(int[] stones) {
        int target = getEqualSubsetSum(stones);
        int length = stones.length;
        int[] dp = new int[target + 1];
        // 初始化
        dp[0] = 0;
        for (int i = 0; i < length; i++) {
            for (int j = target; j >= stones[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
            }
        }
        return sum(stones) - 2 * dp[target];
    }

    public static void main(String[] args) {
        int[] stone = {2, 7, 4, 1, 8, 1};
        System.out.println(lastStoneWeight2(stone));
    }

    /**
     * 求数组总和 即石头总重量
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

    /**
     * 计算等和子集总和
     *
     * @param stone
     * @return
     */
    public static int getEqualSubsetSum(int[] stone) {
        // 求sum / 2 的子集总和
        int target = sum(stone) / 2; // 或sum(stone) >> 1
        System.out.println("target=" + target);
        return target;
    }
}
