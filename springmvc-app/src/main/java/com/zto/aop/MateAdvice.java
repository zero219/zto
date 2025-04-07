package com.zto.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

// 设置该类为spring的bean
@Component
// 设置当前类为AOP切面类
@Aspect
public class MateAdvice {
    /**
     * 匹配符aop
     */

    // 将项目中所有业务层方法的以aop开头的方法匹配
    @Pointcut("execution(* com.zto.*.*Service.aop*(..))")
    private void pt() {
    }

    @Around("pt()")
    public void method(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("around before MateAdvice ...");
        //表示对原始操作的调用
        pjp.proceed();
        System.out.println("around after MateAdvice ...");
    }
}
