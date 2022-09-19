package cglib;

import cglib.factory.CglibProxyFactory;
import cglib.factory.ProxyFactory;
import cglib.start.BeanLauncher;
import com.alibaba.fastjson.JSONObject;
import org.springframework.cglib.proxy.Enhancer;

import java.util.List;

/**
 * @author ebiz_zenggs
 * @Date 2022/8/29
 */
public class Test {

    @org.junit.jupiter.api.Test
    public void daoProxyTest(){
        DaoProxy daoProxy = new DaoProxy();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Dao.class);
        enhancer.setCallback(daoProxy);
        Dao dao = (Dao) enhancer.create();
        dao.select("1", "1");
    }

    @org.junit.jupiter.api.Test
    public void proxyFactoryTest(){
        ProxyFactory proxyFactory = new CglibProxyFactory();
        Dao proxy = proxyFactory.getProxy(new Dao());
        proxy.select("hello cglib", "Cglib");
        proxy.save();
        proxy.update();
    }

    public void hello(){
        System.out.println("Hello world!");
    }

    @org.junit.jupiter.api.Test
    public void test() throws Exception{
        System.out.println("Test start.");
//        Class<?> aClass = Class.forName("cglib.start.BeanLauncher");
//        BeanLauncher aBeanLauncher = ((BeanLauncher) aClass.newInstance());
        BeanLauncher aBeanLauncher = new BeanLauncher();
        List<String> packageArr = aBeanLauncher.PACKAGE_ARR;
        packageArr.add("a");
//        Class<?> bClass = Class.forName("cglib.start.BeanLauncher");
//        BeanLauncher bBeanLauncher = ((BeanLauncher) bClass.newInstance());
        BeanLauncher bBeanLauncher = new BeanLauncher();
        System.out.println(JSONObject.toJSONString(bBeanLauncher.PACKAGE_ARR));
    }

}
