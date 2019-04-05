package cn.savory.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author harriszhang
 * @date 2018/12/6.
 */
@SpringBootApplication
@EnableZuulProxy
public class Program {

    public static void main(String[] args) {

        SpringApplication.run(Program.class, args);
    }
}
