package eightpartessay;

/**
 * 最大子序和（动态规划）
 * 1. 确定dp数组（dp table）以及下标的含义：dp[i]表示包括下标i之前的最大连续子序列和为dp[i]
 * 2. 确定递推公式：dp[i] = max(dp[i - 1] + nums[i], nums[i])
 * 1dp[i - 1] + nums[i]，即：nums[i]加入当前连续子序列和
 * 2nums[i]，即：从头开始计算当前连续子序列和
 * 一定是取最大的，所以dp[i] = max(dp[i - 1] + nums[i], nums[i]);
 * 3. dp数组如何初始化: dp[0] = nums[0]
 * 4. 确定遍历顺序: 递推公式中dp[i]依赖于dp[i - 1]的状态，需要从前向后遍历。
 * 5. 举例推导dp数组：以下
 */
public class MaximumSubarray {
    public static int maximumSubarray(int[] nums) {
        int[] dp = new int[nums.length];
        // 初始化
        dp[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            // ⚠️此处还得判断大小
            max = Math.max(max, dp[i]);
            System.out.println(dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int max = maximumSubarray(nums);
        System.out.println(max);
    }
}
