package jdkProxy.test;

import jdkProxy.extendion.BeanA;
import jdkProxy.extendion.IBeanA;
import jdkProxy.factory.ProxyFactory;
import jdkProxy.vo.UserModel;
import org.apache.poi.ss.formula.functions.T;

/**
 * @author ebiz_zenggs
 * @Date 2022/8/30
 */
public class ProxyFactoryTest {

    public static void main(String[] args) {
        IBeanA obj = ProxyFactory.getObj(BeanA.class,IBeanA.class);
        obj.say();
        UserModel userModel = new UserModel();
        userModel.setToken("adfakjhadskjfasdf");
        obj.log(userModel);
    }

}
