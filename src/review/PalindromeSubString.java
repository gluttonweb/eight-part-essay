package review;

/**
 * 回文子串
 * 1 确定dp数组 dp[i][j] 表示[i,j]范围内为回文串则为true，不为回文串则为false
 * 2 确定递归公式
 * 1) s[i] != s[j], dp[i][j] = false
 * 2) s[i] == s[j],
 * 当 i = j, dp[i][j] = true;
 * 当 j - i = 1, dp[i][j] = true;
 * 当 j - i > 1, dp[i][j] = dp[i + 1][j - 1];
 * 3 初始化 都初始化为false
 * 4 遍历顺序 优先遍历列，然后遍历行
 */
public class PalindromeSubString {

}
