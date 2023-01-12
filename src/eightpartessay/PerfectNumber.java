package eightpartessay;

/**
 * 完数
 * 完全数（Perfect number），又称完美数或完备数，是一些特殊的自然数。它所有的真因子（即除了自身以外的约数）的和（即因子函数），恰好等于它本身。
 */
public class PerfectNumber {

    public static void main(String[] args) {
        int sum = 0;
        for (int perfectNumber = 1; perfectNumber <= 1000; perfectNumber++) {
            for (int factor = 1; factor < perfectNumber; factor++) {
                if (perfectNumber % factor == 0) { // 能整除说明是因子
                    sum = sum + factor;
                }
            }
            if (sum == perfectNumber) {
                System.out.println(perfectNumber);
            }
            sum =0;
        }
    }

}
