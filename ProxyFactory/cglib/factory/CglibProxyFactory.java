package cglib.factory;

import cglib.common.CglibCommonCallBack;
import net.sf.cglib.proxy.Enhancer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ebiz_zenggs
 * @Date 2022/8/30
 */
public class CglibProxyFactory implements ProxyFactory{
    private final Enhancer enhancer = new Enhancer();
    private static final Map<String,Object> BEAN_MAP = new HashMap<>();
//        BeanFactory beanFactory;
    @Override
    public <T> T getProxy(T target) {
//        beanFactory.getBean()
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(new CglibCommonCallBack());
        return (T) enhancer.create();
    }
}
