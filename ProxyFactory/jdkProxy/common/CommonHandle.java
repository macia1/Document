package jdkProxy.common;

import jdkProxy.InvokeHandle;
import jdkProxy.conf.InvokeHandleConf;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author ebiz_zenggs
 * @Date 2022/8/30
 */
public class CommonHandle implements InvocationHandler {


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        InvokeHandleConf invokeHandleConf = new InvokeHandleConf();
        invokeHandleConf.handleInit();
        for (InvokeHandle invokeHandle : invokeHandleConf.getHandleSet()) {
            boolean handle = invokeHandle.handle(proxy, method, args);
        }
        return method.invoke(proxy,args);
//        return target;
    }
}
