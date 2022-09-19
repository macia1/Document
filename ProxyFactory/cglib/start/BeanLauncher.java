package cglib.start;

import cglib.Dao;
import cglib.Test;
import cglib.common.CglibCommonCallBack;
import net.sf.cglib.proxy.Enhancer;
import java.io.File;
import java.lang.reflect.Modifier;
import java.util.*;

/**
 * @author ebiz_zenggs
 * @Date 2022/8/31
 */
public class BeanLauncher {
    // 未处理符号的class文件路径
    public static final List<String> PACKAGE_ARR = new ArrayList<>();
    // 已处理后的class全限定路径
    private static final List<String> CLASSPATH_CLASS = new ArrayList<>();
    // k: bean名称，v bean实例
    private static final Map<String,Object> BEAN_MAP = new HashMap<>();
    public static void run(Class<?> primaryClass) throws Exception {
        packageScan(primaryClass);
    }

    public static <T> T getByType(Class<T> tClass){
        for(Map.Entry<String, Object> entry : BEAN_MAP.entrySet()){
            Object value = entry.getValue();
            if (value.getClass().getSuperclass()==tClass){
                return ((T) value);
            }
        }
        return null;
    }
    /**
     * 递归扫描该目录下所有class类注入到Bean容器中
     * @param primaryClass
     */
    private static void packageScan(Class<?> primaryClass) throws Exception {
        String basePackage = primaryClass.getPackage().getName().replaceAll("\\.", File.separator);
        System.out.printf("base package: %s \n", basePackage);
        String path = Objects.requireNonNull(Thread.currentThread().getContextClassLoader().getResource(primaryClass.getPackage().getName())).getPath();
        beanDI(new File(path));
        for (String s : PACKAGE_ARR) {
            String s1 = s.replaceAll(".*" + basePackage, "").replaceAll("\\\\", ".");
            System.out.println(basePackage+s1);
            CLASSPATH_CLASS.add(basePackage+s1);
        }
        beanInit();
    }

    private static void beanInit() throws Exception {
        for (String s : CLASSPATH_CLASS) {
            Class<?> aClass = Class.forName(s);
            boolean isAbstract = Modifier.isAbstract(aClass.getModifiers());
            boolean isInterface = Modifier.isInterface(aClass.getModifiers());
            if (!isInterface && !isAbstract){
                System.out.println(aClass.getName() + " init.");
                Object o = aClass.newInstance();
                Enhancer enhancer = new Enhancer();
                enhancer.setSuperclass(o.getClass());
                enhancer.setCallback(new CglibCommonCallBack());
                System.out.println(aClass.getName() + " init success.");
                BEAN_MAP.put(aClass.getSimpleName(), enhancer.create());
            }
        }
    }

    private static void beanDI(File file){
        boolean isDirectory = file.isDirectory();
        if (isDirectory){
            File[] files = file.listFiles();
            assert files != null;
            for (File subFiled : files) {
                beanDI(subFiled);
            }
        }else {
            String filePath = file.getPath();
            if(file.getPath().endsWith(".class")){
                filePath = filePath.substring(0, filePath.length() - 6);
                PACKAGE_ARR.add(filePath);
            }
            System.out.printf("文件路径: %s, 文件名: %s \n",/*file.getPath()*/filePath,file.getName());
        }
    }


    public static void main(String[] args) throws Exception {
        run(Dao.class);
        Dao dao = getByType(Dao.class);
        dao.update();
        dao.select("hello ", "world.");
        Test byType = getByType(Test.class);
        byType.hello();
        System.out.println(File.separator);
    }

    public BeanLauncher() {
        System.out.println("BeanLauncher init.");
    }

    static {
        System.out.println("static : hello world.");
    }


}
