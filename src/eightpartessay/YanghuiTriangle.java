package eightpartessay;

/**
 * 杨辉三角
 * 特性：
 * 1 他的两条斜边都是数字1组成，其余的数等于他肩上的两数之和
 * 2 每行数字左右对称，由1开始，逐渐增大
 * 3 第n行的数字个数为n
 * 4 第n行的数字之和为2^n-1;
 */
public class YanghuiTriangle {

    public static void main(String[] args) {
        int max = 10;
        int[][] yanghuiTriangle = new int[max][];
        for (int n = 0; n < yanghuiTriangle.length; n++) {
            yanghuiTriangle[n] = new int[n+1];
        }
        for (int i = 0; i < max; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    yanghuiTriangle[i][j] = 1;
                    continue;
                }
                yanghuiTriangle[i][j] = yanghuiTriangle[i - 1][j - 1] + yanghuiTriangle[i - 1][j];
            }
        }

        for (int[] line : yanghuiTriangle) {
            for (int i : line) {
                System.out.printf("%4d", i);
            }
            System.out.println();
        }
    }
}
