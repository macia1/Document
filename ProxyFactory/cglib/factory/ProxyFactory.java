package cglib.factory;

/**
 * @author ebiz_zenggs
 * @Date 2022/8/30
 */
public interface ProxyFactory {

    <T> T getProxy(T target);

}
