package jdkProxy.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * @author ebiz_zenggs
 * @Date 2022/8/29
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LogAdvice {
}
