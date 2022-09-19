package jdkProxy.handlePool;

import jdkProxy.InvokeHandle;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;

/**
 * @author ebiz_zenggs
 * @Date 2022/8/29
 */
public abstract class InvokeHandleBase{

    public static Set<InvokeHandle> HANDLE_SET = new HashSet<>();

    public abstract InvokeHandleBase addHandle(Set<InvokeHandle> handleSet);

    protected void doHandle(Object proxy, Method method, Object[] args) throws Exception {
        for (InvokeHandle invokeHandle : HANDLE_SET) {
            invokeHandle.handle(proxy,method,args);
        }
    }

    public  void handleInit(){
        addHandle(HANDLE_SET);
    }

    public Set<InvokeHandle> getHandleSet() {
        return HANDLE_SET;
    }

}
