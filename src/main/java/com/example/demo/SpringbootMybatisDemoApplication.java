package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication(scanBasePackages = { "com.example" })
@MapperScan("com.example.mapper")
@EnableConfigurationProperties
public class SpringbootMybatisDemoApplication {

    /**
     * <p>
     * https://www.cnblogs.com/hjwublog/p/10332042.html 主要是Bean的注册，发现机制,各种注解的使用
     * MybatisAutoConfiguration 类，注册bean , mybatis 依赖各种bean
     * DataSourceAutoConfiguration, jdbc 数据库连接初始化，把properties文件转换成bean
     * </p>
     * 
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(SpringbootMybatisDemoApplication.class, args);

        //        ConfigurableApplicationContext context = SpringApplication.run(SpringbootMybatisDemoApplication.class, args);
        //
        //        System.out.println("----------------------" + context.getBean(PropertiesBean.class));
        //        context.close();

    }

}
