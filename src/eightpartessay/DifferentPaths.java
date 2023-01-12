package eightpartessay;

/**
 * 不同路径
 * 1. 确定dp数组（dp table）以及下标的含义：dp[i][j] 表示到达每一个坐标可能的路径种类
 * 2. 确定递推公式：dp[i][j] = dp[i-1][j] + dp[i][j-1]
 * 3. dp数组如何初始化: dp[i][0]=1 dp[0][i]=1 初始化横竖就可
 * 4. 确定遍历顺序: 一行一行遍历从左往右遍历
 * 5. 举例推导dp数组：以下
 */
public class DifferentPaths {
    public static void main(String[] args) {
        int m = 4;
        int n = 7;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                System.out.println("dp" + i + j + "="+dp[i][j]);
            }
        }
        System.out.println(dp[m - 1][n - 1]);
    }
}
