package jdkProxy.factory;

import jdkProxy.common.CommonHandle;
import jdkProxy.extendion.BeanA;
import org.apache.poi.ss.formula.functions.T;
import org.checkerframework.checker.units.qual.K;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author ebiz_zenggs
 * @Date 2022/8/29
 */
public class ProxyFactory{

    public static <T> T getObj(Object impl, Class<T> kClass){
        T o = (T)Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), impl.getClass().getInterfaces(), new CommonHandle());
        return o;
    }

}
