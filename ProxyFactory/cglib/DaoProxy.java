package cglib;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author ebiz_zenggs
 * @Date 2022/8/29
 */
public class DaoProxy implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("Before Dao Invoke.");
        methodProxy.invokeSuper(o, objects);
        System.out.println("After Dao Invoke.");
        return o;
    }
}
