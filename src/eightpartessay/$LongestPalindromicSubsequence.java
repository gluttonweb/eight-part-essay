package eightpartessay;

/**
 * 最长回文子序列（动态规划）
 * 1. 确定dp数组（dp table）以及下标的含义：dp[i][j]表示字符串s在[i, j]范围内最长的回文子序列的长度为dp[i][j]。
 * 2. 确定递推公式：
 * 当s[i] = s[j]，dp[i][j] = dp[i + 1][j - 1] + 2;
 * 当s[i] != s[j]，dp[i][j] = max(dp[i + 1][j], dp[i][j - 1])。
 * (如果s[i]与s[j]不相同，说明s[i]和s[j]的同时加入 并不能增加[i,j]区间回文子串的长度，那么分别加入s[i]、s[j]看看哪一个可以组成最长的回文子序列。
 * 加入s[j]的回文子序列长度为dp[i + 1][j]。
 * 加入s[i]的回文子序列长度为dp[i][j - 1]。
 * 那么dp[i][j]一定是取最大的，即：dp[i][j] = max(dp[i + 1][j], dp[i][j - 1]))
 * 3. dp数组如何初始化:
 * （⚠️首先要考虑当i 和j 相同的情况，从递推公式：dp[i][j] = dp[i + 1][j - 1] + 2; 可以看出 递推公式是计算不到 i 和j相同时候的情况。
 * 所以需要手动初始化一下，当i与j相同，那么dp[i][j]一定是等于1的，即：一个字符的回文子序列长度就是1。
 * 其他情况dp[i][j]初始为0就行，这样递推公式：dp[i][j] = max(dp[i + 1][j], dp[i][j - 1]); 中dp[i][j]才不会被初始值覆盖。）
 * 4. 确定遍历顺序: 从递推公式中可以看出，情况三是根据dp[i + 1][j - 1]是否为true，在对dp[i][j]进行赋值true的。
 * dp[i + 1][j - 1] 在 dp[i][j]的左下角,所以一定要从下到上，从左到右遍历，这样保证dp[i + 1][j - 1]都是经过计算的。
 * 有的代码实现是优先遍历列，然后遍历行，其实也是一个道理，都是为了保证dp[i + 1][j - 1]都是经过计算的。
 * 5. 举例推导dp数组：以下
 */
public class $LongestPalindromicSubsequence {

    public static int longestPalindromicSubsequence(String str) {
        int length = str.length();
        int[][] dp = new int[length + 1][length + 1];
        // 初始化
        for (int i = 0; i < length; i++) {
            dp[i][i] = 1;
        }
        for (int i = length - 1; i >= 0; i--) {
            char aChar = str.charAt(i);
            for (int j = i + 1; j < length; j++) {
                char bChar = str.charAt(j);
                if (aChar == bChar) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][length - 1];
    }

    public static void main(String[] args) {
        String str = "cbbd";
        int maxLength = longestPalindromicSubsequence(str);
        System.out.println(maxLength);
    }
}
