package com.netelis.retail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Alan Chen
 * @description
 * @date 2019/5/14
 */
@EnableSwagger2
@SpringBootApplication
public class RetailApplication {

    public static void main(String[] args) {
        SpringApplication.run(RetailApplication.class, args);
    }

}
