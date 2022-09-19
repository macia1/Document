package jdkProxy.handlePool;

import com.alibaba.fastjson.JSONObject;
import jdkProxy.InvokeHandle;
import jdkProxy.annotation.LogAdvice;

import java.lang.reflect.Method;

/**
 * @author ebiz_zenggs
 * @Date 2022/8/29
 */
public class LogHandle implements InvokeHandle {
    @Override
    public boolean handle(Object proxy, Method method, Object[] args) {
        if (method.getAnnotation(LogAdvice.class) != null || proxy.getClass().getAnnotation(LogAdvice.class) != null){
            System.out.printf("调用#%s#, 入参: %s \n", method.getName(), args == null ? "无" : JSONObject.toJSON(args));
        }
        return true;
    }
}
