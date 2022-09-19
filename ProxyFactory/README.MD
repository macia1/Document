# JdkProxy
+ 通过接口代理目标对象，需要通过接口形式进行调用。
+ jdk自带

# Cglib
+ 不通过接口也可代理目标对象(继承机制)


### Note

1. BeanLauncher中通过Cglib进行类路径进行子目录扫描 实现简单bean注入
2. 循环依赖问题暂无涉及处理
3. 若需要运行测试须要引入cglib依赖
```pom
<dependency>
    <groupId>cglib</groupId>
    <artifactId>cglib</artifactId>
    <version>3.1</version>
</dependency>
```