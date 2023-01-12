package review;

/**
 * 不同路径
 * 1. 确定dp数组（dp table）以及下标的含义：dp[i][j] 表示到达第i，j节点有dp[i][j]条不同路径
 * 2. 确定递推公式：dp[i][j] = dp[i-1][j] + dp[i][j-1]
 * 3. dp数组如何初始化: ⚠️dp[i][0] = 1 dp[0][j] = 1
 * 4. 确定遍历顺序: 从左到右一层一层遍历
 * 5. 举例推导dp数组：以下
 */
public class DifferentPaths {
    public static void main(String[] args) {

    }
}
