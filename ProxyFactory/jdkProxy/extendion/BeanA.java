package jdkProxy.extendion;

import jdkProxy.annotation.Auth;
import jdkProxy.annotation.LogAdvice;
import jdkProxy.vo.UserModel;

/**
 * @author ebiz_zenggs
 * @Date 2022/8/30
 */
public class BeanA implements IBeanA{

    @LogAdvice
    public void say(){
        System.out.println("BeanA: hello.");
    }

    @Auth
    @LogAdvice
    public void log(UserModel userModel){
        System.out.println("请求登录");
    }

}
