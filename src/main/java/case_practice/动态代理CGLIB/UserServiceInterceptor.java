package case_practice.动态代理CGLIB;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.omg.PortableInterceptor.Interceptor;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class UserServiceInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("Before calling " + method.getName());
        Object result = methodProxy.invokeSuper(o, objects);
        System.out.println("After calling " + method.getName());
        return result;
    }
}
