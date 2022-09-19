package jdkProxy.handlePool;

import jdkProxy.InvokeHandle;
import jdkProxy.annotation.Auth;
import jdkProxy.vo.UserModel;

import java.lang.reflect.Method;
import java.util.Map;

/**
 * @author ebiz_zenggs
 * @Date 2022/8/29
 */
public class AuthAdvice implements InvokeHandle{

    @Override
    public boolean handle(Object proxy, Method method, Object[] args) throws Exception {
        boolean userVerification = false;
        if (method.getClass().getAnnotation(Auth.class) != null || method.getAnnotation(Auth.class) != null){
            for (int i = 0; i < args.length; i++) {
                Object arg = args[i];
                if (arg instanceof UserModel){
                    System.out.println("用户token:" + ((UserModel) arg).getToken());
                    userVerification = true;
                }
            }
        }else {
            return false;
        }
        return userVerification;
    }
}
