package case_practice.动态代理CGLIB;

import net.sf.cglib.proxy.Enhancer;

import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserServiceImpl.class);
        enhancer.setCallback(new UserServiceInterceptor());

        UserService proxy = (UserService) enhancer.create();
        proxy.doSomething();
    }
}
