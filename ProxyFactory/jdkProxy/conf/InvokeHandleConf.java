package jdkProxy.conf;

import jdkProxy.InvokeHandle;
import jdkProxy.handlePool.AuthAdvice;
import jdkProxy.handlePool.InvokeHandleBase;
import jdkProxy.handlePool.LogHandle;

import java.util.Set;

/**
 * @author ebiz_zenggs
 * @Date 2022/8/29
 */
public class InvokeHandleConf extends InvokeHandleBase {

    @Override
    public InvokeHandleBase addHandle(Set<InvokeHandle> invokeHandles) {
        invokeHandles.add(new LogHandle());
        invokeHandles.add(new AuthAdvice());
        return this;
    }
}
