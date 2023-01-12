package review;

public class testTry {
    public static void main(String[] args) throws Exception {
        try {
            System.out.println(1);
            throw new Exception("2");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println(3);
            try {
                throw new Exception("4");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
