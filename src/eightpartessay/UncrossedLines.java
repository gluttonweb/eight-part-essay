package eightpartessay;

/**
 * 不相交的线（动态规划）
 * ⚠️分析题意 其实就是求两个数组的最长公共子序列！
 * 1. 确定dp数组（dp table）以及下标的含义：dp[i][j]表示数组A[0->i - 1]和B[0->j - 1]的最长公共子序列长度为dp[i][j]
 * 2. 确定递推公式：
 * 当A[i] = B[j], dp[i][j] = dp[i - 1][j - 1] + 1
 * 当A[i] != B[j], dp[i][j] = max(dp[i-1][j], dp[i][j-1])
 * 3. dp数组如何初始化: dp[0][0] = 0; dp[0][j] = 0; dp[i][0] = 0;
 * 4. 确定遍历顺序: 从前往后遍历
 * 5. 举例推导dp数组：以下
 */
public class UncrossedLines {

    public static int uncrossedLines(int[] a, int[] b) {
        int aLength = a.length;
        int bLength = b.length;
        int[][] dp = new int[aLength + 1][bLength + 1];
        for (int i = 1; i <= aLength; i++) {
            for (int j = 1; j <= bLength; j++) {
                if (a[i - 1] == b[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[aLength][bLength];
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 4};
        int[] b = {1, 4, 2};
        int maxLength = uncrossedLines(a, b);
        System.out.println(maxLength);
    }
}
