package com.zto.aop;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

// 设置该类为spring的bean
@Component
// 设置当前类为AOP切面类
@Aspect
public class MyAdvice {

    // region 无参无返回值aop

    // 设置切入点方法
    @Pointcut("execution(void com.zto.service.BookService.Test())")
    private void pt() {
    }

    // 当前通知方法在原始切入点方法前运行
    @Before("pt()")
    public void before() {
        System.out.println("before MyAdvice ...");
    }

    @After("pt()")
    public void after() {
        System.out.println("after MyAdvice ...");
    }

    @AfterReturning("pt()")
    public void afterReturning() {
        System.out.println("afterReturning MyAdvice ...");
    }

    @AfterThrowing("pt()")
    public void afterThrowing() {
        System.out.println("afterThrowing MyAdvice ...");
    }
    // endregion
}
