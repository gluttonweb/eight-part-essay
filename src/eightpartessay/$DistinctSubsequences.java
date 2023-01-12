package eightpartessay;

/**
 * 不同的子序列（动态规划）（编辑距离）
 * 1. 确定dp数组（dp table）以及下标的含义：dp[i][j]表示以i-1为结尾的s子序列中出现以j-1为结尾的t的个数为dp[i][j]。
 * 2. 确定递推公式：
 * s[i - 1] = t[j - 1]，dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
 * s[i - 1] != t[j - 1]，dp[i][j] = dp[i - 1][j];
 * （⚠️ 这一类问题，基本是要分析两种情况
 * s[i - 1] 与 t[j - 1]相等
 * s[i - 1] 与 t[j - 1] 不相等
 * 当s[i - 1] 与 t[j - 1]相等时，dp[i][j]可以有两部分组成。
 * 一部分是用s[i - 1]来匹配，那么个数为dp[i - 1][j - 1]。
 * 一部分是不用s[i - 1]来匹配，个数为dp[i - 1][j]。
 * 这里可能有同学不明白了，为什么还要考虑 不用s[i - 1]来匹配，都相同了指定要匹配啊。
 * 例如： s：bagg 和 t：bag ，s[3] 和 t[2]是相同的，但是字符串s也可以不用s[3]来匹配，即用s[0]s[1]s[2]组成的bag。
 * 当然也可以用s[3]来匹配，即：s[0]s[1]s[3]组成的bag。
 * 所以当s[i - 1] 与 t[j - 1]相等时，dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
 * 当s[i - 1] 与 t[j - 1]不相等时，dp[i][j]只有一部分组成，不用s[i - 1]来匹配，即：dp[i - 1][j]
 * 所以递推公式为：dp[i][j] = dp[i - 1][j]）
 * 3. dp数组如何初始化: dp[0][0] = 1；dp[i][0] = 1；dp[0][j] = 0;
 * （⚠️从递推公式dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j]; 和 dp[i][j] = dp[i - 1][j]; 中可以看出dp[i][0] 和dp[0][j]是一定要初始化的。
 * 每次当初始化的时候，都要回顾一下dp[i][j]的定义，不要凭感觉初始化。
 * dp[i][0]表示什么呢？
 * dp[i][0] 表示：以i-1为结尾的s可以随便删除元素，出现空字符串的个数。
 * 那么dp[i][0]一定都是1，因为也就是把以i-1为结尾的s，删除所有元素，出现空字符串的个数就是1。
 * 再来看dp[0][j]，dp[0][j]：空字符串s可以随便删除元素，出现以j-1为结尾的字符串t的个数。
 * 那么dp[0][j]一定都是0，s如论如何也变成不了t。
 * 最后就要看一个特殊位置了，即：dp[0][0] 应该是多少。
 * dp[0][0]应该是1，空字符串s，可以删除0个元素，变成空字符串t。
 * 从递推公式可以看出dp[i][j]都是依赖于dp[i - 1][j - 1] 和 dp[i][j - 1]，所以dp[0][0]和dp[i][0]是一定要初始化的）
 * 4. 确定遍历顺序: 从递推公式dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j]; 和 dp[i][j] = dp[i - 1][j]; 中可以看出dp[i][j]都是
 * 根据左上方和正上方推出来的。所以遍历的时候一定是从上到下，从左到右，这样保证dp[i][j]可以根据之前计算出来的数值进行计算。
 * 5. 举例推导dp数组：以下
 */
public class $DistinctSubsequences {

    public static int distinceSubsequences(String a, String b) {
        int aLength = a.length();
        int bLength = b.length();
        int[][] dp = new int[aLength + 1][bLength + 1];
        // 初始化
        for (int i = 0; i <= aLength; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j <= bLength; j++) {
            dp[0][j] = 0;
        }
        dp[0][0] = 1;
        for (int i = 1; i <= aLength; i++) {
            char aChar = a.charAt(i - 1);
            for (int j = 1; j <= bLength; j++) {
                char bChar = b.charAt(j - 1);
                if (aChar == bChar) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
                System.out.println("dp" + i + j + "=" + dp[i][j]);
            }
        }
        return dp[aLength][bLength];
    }

    public static void main(String[] args) {
        String a = "babgbag";
        String b = "bag";
        int num = distinceSubsequences(a, b);
        System.out.println(num);
    }
}
