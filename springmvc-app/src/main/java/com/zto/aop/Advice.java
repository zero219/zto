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
public class Advice {

    /**
     * 环绕aop，@Around("pt()")不绑定aop不生效
     */


    @Pointcut("execution(public com.zto.domain.Book com.zto.service.BookService.selectById(int))")
    private void pt() {
    }

    @Around("pt()")
    public Object aroundObj(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("around before advice ...Object");
        //表示对原始操作的调用
        Object obj = pjp.proceed();
        System.out.println("around after advice ...Object");
        return obj;
    }

    // @Around("pt()")
    public void around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("around before advice ...");
        //表示对原始操作的调用
        pjp.proceed();
        System.out.println("around after advice ...");
    }
}
