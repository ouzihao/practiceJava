package case_practice.动态代理Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

//定义了一个InvocationHandler接口的实现类MyInvocationHandler，
// 它持有一个目标对象，并在调用目标方法之前和之后输出额外的日志信息
public class MyInvocationHandler implements InvocationHandler {
    private Object target;

    public MyInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Before calling..." + method.getName());
        Object result = method.invoke(target, args);
        System.out.println("After calling..." + method.getName());
        return result;
    }
}
