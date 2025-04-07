package com.zto.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@Configuration
@ComponentScan({"com.zto.controller","com.zto.config"})
@EnableWebMvc
public class SpringMvcConfig {
}
