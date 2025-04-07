package com.zto.config;

import org.springframework.context.annotation.*;
import org.springframework.transaction.annotation.EnableTransactionManagement;

// Configuration注解：将该类设置成spring的配置类
@Configuration
// ComponentScan注解：扫描,用于加载使用注解格式定义的bean
@ComponentScan({
        "com.zto.aop",
        "com.zto.exception",
        "com.zto.interceptor",
        "com.zto.mapper",
        "com.zto.service"})
// PropertySource注解：加载properties；classpath表示该项目下的根目录
@PropertySource("classpath:jdbc.properties")
// 引入
@Import({JdbcConfig.class, MyBatisConfig.class})
// 开启AOP功能
@EnableAspectJAutoProxy
// 开启事务驱动
@EnableTransactionManagement
public class SpringConfig {
}
