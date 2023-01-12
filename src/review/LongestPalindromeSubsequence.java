package review;

/**
 * 最长回文子序列
 * 1 确定dp数组 dp[i][j] 表示[i,j]范围内子序列最长为dp[i][j]
 * 2 递推公式
 * s[i] != s[j], dp[i][j] = max(dp[i][j - 1], dp[i + 1][j])
 * s[i] == s[j],
 * i == j, dp[i][j] = 1
 * j - i = 1, dp[i][j] = 2
 * j - i > 1, dp[i][j] = dp[i + 1][j - 1] + 2
 * 3 初始化 当 i = j时，dp[i][j] = 1，其他情况dp[i][j] = 0
 * 4 遍历顺序 优先遍历列，然后遍历行
 */
public class LongestPalindromeSubsequence {

}
