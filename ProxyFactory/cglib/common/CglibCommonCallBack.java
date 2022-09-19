package cglib.common;

import com.alibaba.fastjson.JSONObject;
import jdkProxy.annotation.LogAdvice;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.Type;

/**
 * @author ebiz_zenggs
 * @Date 2022/8/30
 */
public class CglibCommonCallBack implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        JSONObject arg = new JSONObject();
        if (method.getDeclaringClass().getAnnotation(LogAdvice.class) != null || method.getAnnotation(LogAdvice.class) != null) {
            if(method.getParameterCount()!=0){
                Parameter[] parameters = method.getParameters();
                for (int i = 0; i < parameters.length; i++) {
                    Parameter parameter = parameters[i];
                    arg.put(parameter.getName(), args[i]);
                }
            }
            System.out.printf("调用类: %s, 方法: %s, 入参: %s \n", method.getDeclaringClass().getName(), method.getName(), args != null ? JSONObject.toJSON(arg) : "无");
            Object result = methodProxy.invokeSuper(o, args);
            System.out.printf("调用类: %s, 方法: %s, 出参: %s \n", method.getDeclaringClass().getName(), method.getName(), result != null ? JSONObject.toJSON(result) : "无");
            return result;
        }
        return methodProxy.invokeSuper(o, args);
    }
}
