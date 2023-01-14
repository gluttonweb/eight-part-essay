package proxy;

/**
 * 被代理服务实现
 */
public class SomeServiceImpl implements SomeService {
    @Override
    public void oneMethod() {
        System.out.println("oneMethod");
    }
}
