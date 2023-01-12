package review;

public abstract class testAbstractClass {

    private Integer a = 10;
    public Integer b = 15;
    protected String c = "test";

    // 抽象类可以有构造方法
    public testAbstractClass() {
    }

    // 实例方法
    private void test() { // 可以有具体实现
        System.out.println("test!");
    }

    // 静态方法
    protected static void test1() {

    }

    // 抽象方法
    // ⚠️注意没有方法体
    public abstract void test2();

}



