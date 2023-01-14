package proxy;

import java.lang.reflect.Proxy;

/**
 * JDK动态代理
 */
public class JdkProxy {
    public static void main(String[] args) {
        // 被代理类
        SomeService targetService = new SomeServiceImpl();
        // 实现Invocationhandler
        Handler handler = new Handler(targetService);
        // 新建代理实例
        SomeService proxy = (SomeService) Proxy.newProxyInstance(targetService.getClass().getClassLoader(), targetService.getClass().getInterfaces(), handler);
        // 执行前代理
        System.out.println("before run oneMethod");
        // 执行
        proxy.oneMethod();
        // 执行后代理
        System.out.println("after run oneMethod");
    }


}
