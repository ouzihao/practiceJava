package case_practice.动态代理Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;


//使用Java自带的Proxy类和InvocationHandler接口实现动态代理
public class Main {
    public static void main(String[] args) {

        UserService userService = new UserServiceImpl();
        InvocationHandler handler = new MyInvocationHandler(userService);
        //Proxy类的newProxyInstance方法动态生成代理对象
        UserService proxy = (UserService) Proxy.newProxyInstance(
                userService.getClass().getClassLoader(),
                userService.getClass().getInterfaces(),
                handler
        );
        proxy.doSomething();
    }
}
