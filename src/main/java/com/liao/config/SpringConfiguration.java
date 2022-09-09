package com.liao.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan("com.liao")
@Import({DataSourceConfiguration.class})
public class SpringConfiguration {

}
