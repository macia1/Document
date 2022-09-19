package jdkProxy;

import java.lang.reflect.Method;

/**
 * @author ebiz_zenggs
 * @Date 2022/8/29
 */
public interface InvokeHandle {

    boolean handle(Object proxy, Method method, Object[] args) throws Exception;

}
