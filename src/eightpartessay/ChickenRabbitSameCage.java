package eightpartessay;

/**
 * 鸡兔同笼（穷举法）
 */
public class ChickenRabbitSameCage {

    public static void main(String[] args) {
        int c;
        int r;
        for (c = 0, r = 35; c <= 35 && r >= 0; c++, r--) {
            if (c * 2 + r * 4 == 94) {
                System.out.println("c=" + c + "; r=" + r);
            }
        }
    }
}
